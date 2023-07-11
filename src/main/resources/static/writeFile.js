const fs = require('fs');

let array = []
let centerLat = 37.5665
let centerLng = 126.9780
let count = 0;

roof()
function roof(){
  if(count<300){
    centerLat = centerLat+count*0.00001
    centerLng = centerLng+count*0.00001
    let object = {
      lat: centerLat,
      lng: centerLng,
      title: 'point'+count
    }
    array.push(object) 
    count++
    roof()
  }else{
    console.log(array.length)
    writeFile(JSON.stringify(array))

  }
}

function writeFile(data){
  fs.writeFile('location.json', data, (err) => {
    if (err) throw err;
    console.log('File has been written.');
  });
  

}
