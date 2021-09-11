const express = require("express")
const app = express()

// use the express-static middleware
app.use(express.static("."))

app.post("/login", (req, res) {
    
})

// define the first route
app.get('/*', function(req, res) {
    res.sendFile(__dirname + '/login.html');
});

console.log(__dirname);
// start the server listening for requests
app.listen(process.env.PORT || 8081, () => console.log("Server is running..."));
