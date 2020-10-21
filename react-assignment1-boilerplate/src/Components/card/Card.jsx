import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';
import ReactCard from 'react-bootstrap/Card';
export class Card extends Component {
    constructor(props) {
        super(props); 
        //this.hadleOnClick = this.hadleOnClick.bind(this);    
    }
    hadleOnClick= (news) =>{
        console.log(news)
    }
    render() {
        return (
            <div>
                <ReactCard style={{ width: '18rem' }}>
                <ReactCard.Img variant="top" src={this.props.news.urlToImage} />
                <ReactCard.Body>
                    <ReactCard.Title>{this.props.news.author}</ReactCard.Title>
                    <ReactCard.Subtitle className="mb-2 text-muted">{this.props.news.title}</ReactCard.Subtitle>
                    <Button onClick={() => this.hadleOnClick(this.props.news)}>Read Later</Button>
                </ReactCard.Body>
            </ReactCard>
            </div>
        )
    }
}

export default Card
