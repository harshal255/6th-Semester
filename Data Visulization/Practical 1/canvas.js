// Question 1

var canvasA = document.getElementById("canvas-a");
var ctxA = canvasA.getContext("2d");
ctxA.beginPath();
ctxA.moveTo(10, 10);
ctxA.lineTo(190, 190);
ctxA.stroke();

// Question 2

var canvasB = document.getElementById("canvas-b");
var ctxB = canvasB.getContext("2d");
ctxB.beginPath();
ctxB.arc(100, 100, 50, 0, 2 * Math.PI);
ctxB.stroke();

// Question 3

var canvasC = document.getElementById("canvas-c");
var ctxC = canvasC.getContext("2d");
ctxC.font = "20px Arial";
ctxC.fillText("Hello,Harshal Kahar!", 20, 100);

// Question 4

var canvasD = document.getElementById("canvas-d");
var ctxD = canvasD.getContext("2d");
ctxD.font = "20px Arial";
ctxD.strokeText("Hello,Harshal Kahar !", 20, 100);

// Question 5


var canvasE = document.getElementById("canvas-e");
var ctxE = canvasE.getContext("2d");
var gradientE = ctxE.createLinearGradient(0, 0, 200, 0);
gradientE.addColorStop(0, "red");
gradientE.addColorStop(1, "white");
ctxE.fillStyle = gradientE;
ctxE.fillRect(0, 0, 200, 200);

// Question 6


var canvasF = document.getElementById("canvas-f");
var ctxF = canvasF.getContext("2d");
var gradientF = ctxF.createRadialGradient(100, 100, 20, 100, 100, 100);
gradientF.addColorStop(0, "red");
gradientF.addColorStop(1, "white");
ctxF.fillStyle = gradientF;
ctxF.fillRect(0, 0, 200, 200);

// Question 7

var canvasG = document.getElementById("canvas-g");
var ctxG = canvasG.getContext("2d");
var imgG = new Image();
imgG.onload = function () {
    // Draw the image at the size of the canvas
    ctxG.drawImage(imgG, 0, 0, 500, 270);
};
imgG.src = "https://res.cloudinary.com/dlsxq98fr/image/upload/v1676813902/compress_burning_desier_nszpbm.jpg";