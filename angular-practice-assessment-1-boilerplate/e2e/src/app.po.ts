import { browser, by, element,ElementFinder } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl);
  }

  getCenterText():ElementFinder{
    return element(by.css('h1'));
  }
}
