import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';
import ReactCard from 'react-bootstrap/Card';
export class DisplayCard extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <div>
                <ReactCard style={{ width: '18rem' }}>
                    <ReactCard.Img variant="top" src={this.props.news.urlToImage} />
                    <ReactCard.Body>
                        <ReactCard.Title>{this.props.news.author}</ReactCard.Title>
                        <ReactCard.Subtitle className="mb-2 text-muted">{this.props.news.title}</ReactCard.Subtitle>
                    </ReactCard.Body>
                </ReactCard>
            </div>
        )
    }
}

export default DisplayCard
