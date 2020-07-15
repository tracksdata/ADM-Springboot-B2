fetch('http://localhost:8080/api/flights')
.then(response =>response.json())
.then(flights =>{
    console.log(flights);
    
})
