import { AppPage } from './app.po';
import { browser, element, by } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  // test for checking base url is redirected to base url or not
  it ('should load a page and verify the url', () => {
    browser.get('/');
    expect(browser.getCurrentUrl())
        .toEqual(browser.baseUrl + '');
  });

  // test for checking centred text 
  it('should display center text', () => {
    page.navigateTo();
    expect(page.getCenterText).toBeTruthy('<h1> should exist in todo.component.html');
    expect(element(by.css('h1')).getText()).toEqual('Contacts List App');
  });

  // test to check empty input to add contact
  it('should check person component for name validation',() => {
    page.navigateTo();
    element(by.css('input[type="text"]')).sendKeys();
    element(by.css('input[type="number"]')).sendKeys(387482748);
    element(by.css('.btn')).click();
    expect(element(by.css('.alert-danger')).getText()).toBe('Name is required')
  });

  // test to check name as input and number as null
  it('should check person component for mobile validation',() => {
    page.navigateTo();
    element(by.css('input[type="text"]')).sendKeys("test");
    element(by.css('input[type="number"]')).sendKeys();
    element(by.css('.btn')).click();
    expect(element(by.css('.alert-danger-mobile')).getText()).toBe('Mobile is required')
  });

  // test to checking after table caption
  it('should have table caption', () => {
    page.navigateTo();
    expect(element(by.css('caption')).getText()).toBe('Contacts list')

  });

});
