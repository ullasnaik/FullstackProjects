import React, { Component } from 'react'
import ReactCard from 'react-bootstrap/Card';
export class DisplayCard extends Component {

    render() {
        return (
            <div>
                <ReactCard style={{ width: '18rem' }}>
                    <ReactCard.Img variant="top" className="BeerListItem-img" src={"https://www.cricapi.com/playerpic/" + this.props.player.pid + ".jpg"}
                        onError={(e) => { e.target.onerror = null; e.target.src = 'https://kctherapy.com/wp-content/uploads/2019/09/default-user-avatar-300x293.png' }} />
                    <ReactCard.Body>
                        <ReactCard.Title>{this.props.player.name}</ReactCard.Title>
                        <ReactCard.Subtitle className="mb-2 text-muted">{this.props.player.fullName}</ReactCard.Subtitle>
                    </ReactCard.Body>
                </ReactCard>
            </div>
        )
    }
}

export default DisplayCard
