const http = require('http');
const server = http.createServer(function (request, response) {
	console.log(request.url);
    if(request.method === "POST"){//handle post request from client
		//any handling in here
		if(request.url === "/login"){//if request url is /additem
			response.statusCode = 500;//sets status to successful
            response.write("ok");
			response.end();
		}else{//else unknown request url sent
			response.statusCode = 404;
			response.write("Unknwn resource.");
			response.end();
		}
	}else{//else unknown request url sent
		response.statusCode = 404;
		response.write("Unknwn resource.");
		response.end();
	}
});

//Server listens on port 8282
server.listen(8282);
console.log('Server running at http://127.0.0.1:8282/');
