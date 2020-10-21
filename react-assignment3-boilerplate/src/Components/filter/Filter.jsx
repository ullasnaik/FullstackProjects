import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown';
import FormControl from 'react-bootstrap/FormControl';
import { getSourceList } from '../../Services/services';

export class Filter extends Component {
    constructor(props) {
        super(props)
        this.state = {
            filter: {
                endpoints: "",
                country: "",
                category: "",
                sources: "",
                key: "",
                pageSize: 20,
                page: 1
            }
        }
        this.sourceList = [];
    }
    componentDidMount() {
        this.getAllSources(this.state.filter.country)
    }
    componentDidUpdate() {
        this.getAllSources(this.state.filter.country)
    }

    getAllSources = () => {
        getSourceList(this.state.filter.country).then(res => {
            this.sourceList = res.sources;
            console.log("Updated souce list", this.sourceList);
        });
    }

    handleSelect = (eventKey, e) => {
        console.log('Filter Before : ', this.state.filter)
        console.log('name', e.target.name);
        console.log('value', e.target.innerHTML);
        console.log('country :::::', this.state.filter.country);
        if (e.target.name != "search") {
            this.setState(
                { filter: { ...this.state.filter, [e.target.name]: e.target.innerHTML.trim() } },
                () => {
                    this.props.applyFilter(this.state.filter);
                }
            );
            console.log(this.state.filter)
        }

    }
    handleChange = e => {
        this.setState({ filter: { ...this.state.filter, [e.target.name]: e.target.value } });
        console.log(this.state.filter)
    };

    pageChange = (e) => {
        console.log(e.target.name)
        if (e.target.name == "increment") {
            this.setState(
                { filter: { ...this.state.filter, page: this.state.filter.page + 1 } },
                () => { this.props.setPage(this.state.filter) }
            )
        } else {
            if (this.state.filter.page > 1) {
                this.setState(
                    { filter: { ...this.state.filter, page: this.state.filter.page - 1 } },
                    () => { this.props.setPage(this.state.filter) }
                )
            }
        }
    }
    render() {
        return (
            <Form inline>
                <DropdownButton onSelect={this.handleSelect} id="endpoints" variant="outline-info" title={this.state.filter.endpoints === "" ? "Endpoints" : this.state.filter.endpoints}>
                    <Dropdown.Item name="endpoints"  id="top-headlines" key="top-headlines">top-headlines</Dropdown.Item>
                    <Dropdown.Item name="endpoints" id="everything" key="everything">everything</Dropdown.Item>
                </DropdownButton>
                <DropdownButton onSelect={this.handleSelect} id="country" variant="outline-info" title={this.state.filter.country === "" ? "Country" : this.state.filter.country}>
                    {
                        [
                            'ae', 'ar', 'at', 'au', 'be', 'bg', 'br', 'ca', 'ch', 'cn', 'co', 'cu', 'cz', 'de', 'eg', 'fr', 'gb', 'gr', 'hk', 'hu', 'id', 'ie', 'il', 'in', 'it', 'jp', 'kr', 'lt', 'lv', 'ma', 'mx', 'my', 'ng', 'nl', 'no', 'nz', 'ph', 'pl', 'pt', 'ro', 'rs', 'ru', 'sa', 'se', 'sg', 'si', 'sk', 'th', 'tr', 'tw', 'ua', 'us', 've', 'za'
                        ].map((country) => (
                            <Dropdown.Item name="country" id={country} key={country}>{country}</Dropdown.Item>
                        ))
                    }
                </DropdownButton>
                <DropdownButton onSelect={this.handleSelect} id="category" variant="outline-info" title={this.state.filter.category === "" ? "Category" : this.state.filter.category}>
                    {
                        [
                            'business', 'entertainment', 'general', 'health', 'science', 'sports', 'technology'
                        ].map((category) => (
                            <Dropdown.Item name="category" id={category} key={category}>{category}</Dropdown.Item>
                        ))
                    }
                </DropdownButton>
                <DropdownButton onSelect={this.handleSelect} id="sources" variant="outline-info" title={this.state.filter.sources === "" ? "Sources" : this.state.filter.sources}>
                    {
                        this.sourceList.map((s) => (
                            <Dropdown.Item name="sources" key={s.id}>{s.name}</Dropdown.Item>
                        ))
                    }
                </DropdownButton>
                <DropdownButton onSelect={this.handleSelect} id="pageSize" variant="outline-info" title={this.state.filter.pageSize === "" ? "PageSize" : "PageSize : " + this.state.filter.pageSize}>
                    {
                        [...Array(101).keys()].filter((x) => x >= 20 & x % 5 === 0).map((i) => (
                            <Dropdown.Item name="pageSize" key={i}>{i}</Dropdown.Item>
                        ))
                    }
                </DropdownButton>
                <FormControl name="key" type="text" variant="outline-info" placeholder="news key" className="mr-sm-2" onChange={this.handleChange} />
                <Button onClick={() => this.props.applyFilter(this.state.filter)} name="search" variant="outline-info">Search</Button>
                <Button variant="outline-info" name="decrement" onClick={this.pageChange}>&lt;</Button>
                <Button variant="outline-info">{this.state.filter.page}</Button>
                <Button variant="outline-info" name="increment" onClick={this.pageChange}>&gt;</Button>
            </Form >
        )
    }
}

export default Filter