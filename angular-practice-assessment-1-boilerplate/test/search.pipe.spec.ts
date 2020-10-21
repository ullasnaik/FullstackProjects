import { Contact } from 'src/app/models/Contact';
import { SearchPipe } from '../src/app/pipe/search.pipe';

const pipe = new SearchPipe();
const contacts:Contact[] = [
  {
      name:"Ravi",
      mobile:1234567890
  },
  {
    name:"abc",
    mobile:9876543210
  },
  {
    name:"xyz",
    mobile:7834210723
  }
]

describe('SearchPipe', () => {

  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });

  //testing the search pipe based on name
  it('transform() should return result based on name',() => {
    let result:Contact[] = [{
        name:"abc",
        mobile:9876543210
      }] 
    expect(new SearchPipe().transform(contacts,"abc")).toEqual(result);
  });

  //testing the search pipe based on mobile number
  it('transform() should return result based on mobile number',() => {
    let result:Contact[] = [
      {
        name:"abc",
        mobile:9876543210
      },
      {
        name:"xyz",
        mobile:7834210723
      }] 
    expect(new SearchPipe().transform(contacts,"210")).toEqual(result);
  });

});
