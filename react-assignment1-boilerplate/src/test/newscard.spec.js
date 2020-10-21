
import Card from '../Components/card/Card';
import React from "react";
import { render, unmountComponentAtNode } from "react-dom";
import { act } from "react-dom/test-utils";

const propVal = {
    "author": "India.com Lifestyle Staff",
    "content": "Food has a great role to play in weight loss. What you eat and what you stay away from can have a prominent impact on your overall weight. Those who are already on a weight loss journey, usually bing… [+1517 chars]",
    "description": "Read on to know about the vitamin D that can help you get an attractive waistline.",
    "publishedAt": "2020-08-21T05:57:19Z",
    "source": {
        "id": null,
        "name": "India.com"
    },
    "title": "How to Lose Belly Fat: Include This Vitamin in Your Daily Diet And Shed Those Extra Kilos - India.com",
    "url": "https://www.india.com/lifestyle/how-to-lose-belly-fat-include-this-vitamin-in-your-daily-diet-and-shed-those-extra-kilos-4117970/",
    "urlToImage": "https://www.india.com/wp-content/uploads/2020/08/Vitamin-D.jpg"
}
let container = null;
beforeEach(() => {
  // setup a DOM element as a render target
  container = document.createElement("div");
  document.body.appendChild(container);
});

afterEach(() => {
  // cleanup on exiting
  unmountComponentAtNode(container);
  container.remove();
  container = null;
});

it("renders with or without a name", () => {
    act(() => {
      render(<Card news={propVal}/>, container);
    });
    expect(container.textContent).toContain("India.com Lifestyle Staff");
});

it("renders with or without a name", () => {
  act(() => {
    render(<Card news={propVal}/>, container);
  });
  expect(container.textContent).toContain("India.com Lifestyle Staff");
});

it("renders with or without a name", () => {
  act(() => {
    render(<Card news={propVal}/>, container);
  });
  expect(container.textContent).toContain("India.com Lifestyle Staff");
});

it("renders with or without a name", () => {
  act(() => {
    render(<Card news={propVal}/>, container);
  });
  expect(container.textContent).toContain("India.com Lifestyle Staff");
});

it("renders with or without a name", () => {
  act(() => {
    render(<Card news={propVal}/>, container);
  });
  expect(container.textContent).toContain("India.com Lifestyle Staff");
});

export default Card;