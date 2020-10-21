import React from "react";
import { render, unmountComponentAtNode } from 'react-dom';
import { act } from 'react-dom/test-utils';
import Home from '../Components/home/Home';

let container = null;
beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
})

afterEach(() => {
    unmountComponentAtNode(container);
    container.remove();
    container = null;
})
it('Render the card', () => {
    act(() => {
        render(<Home />, container)
    })
    expect(container.textContent).toContain("Session1");

})
