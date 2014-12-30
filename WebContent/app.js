angular.module('recaptcha', []).controller('main', function ($scope, recaptchaService) {
  $scope.submitForm = function(item){
    if(grecaptcha.getResponse()){
      item.captchaResponse = grecaptcha.getResponse(); //This will add the response string to the object you are sending to your server so you can make your get request server side to verify
      recaptchaService.sendForm(item).then(function(response){
        $scope.response = response.data;
        $scope.item = '';
      });
    } else {
      $scope.error = "Please Verify you are not a robot";
    }
  };
}).service('recaptchaService', function($http){
  return {
   sendForm: function (item) {
    console.log(item);
     return $http({
      method: 'POST',
      url: '/recaptcha',
      data: item
     });
   }
  }
});