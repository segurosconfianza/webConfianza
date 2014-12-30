var express = require('express'),
  request = require('request'),
  bodyParser = require('body-parser'),
  port = 8881,
  app = express(),
  captchaUrl ='https://www.google.com/recaptcha/api/siteverify?secret=6Ld7av4SAAAAAPqyLaN63Q2qNBZVu1-ESWUvUjLq&response=';

app.use(express.static(__dirname + '/public'));
app.use(bodyParser.json());

app.post('/recaptcha', function(req, res){
  checkCaptcha(req.body.captchaResponse, function(response){
    console.log(response.success);
  if(response.success){
    res.send("WOOT! you are not a robot");
  } else {
    res.send("BAD! you are a robot");
  }
  });
});

var checkCaptcha = function(captchaResponse, cb){
  request.get(captchaUrl + captchaResponse, function(err, response, body){
    if(err){
      console.log("error: ", err);
    } else {
      console.log(body);
      return cb(JSON.parse(body));
    }
  });
};

app.listen(port, function () {
  console.log('listening on port: ', port);
});