<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            canvas{
                border: 3px solid black;
                margin: 25%;
            }


        </style>
    </head>
    <body>
        <h1>Bienvenido al Mapa ${mapId}</h1>
        <div id=canvaContainer>
            <canvas id="game" width="700" height="700"></canvas>
        </div>

        <script type = "application/json" id="roomData">
            ${room}
        </script>

        <script>
            let canvas = document.getElementById('game');
            let ctx = canvas.getContext('2d');


            let roomString = document.getElementById("roomData").innerHTML;
            roomString = roomString.replace(";", "");
            let room = JSON.parse(roomString);
            drawRoom(room);


            let brujula = new Image();
            brujula.src = '/img/brujula.jpg';

            brujula.onload = function(){
                ctx.drawImage(brujula, 500, 500, 200, 200);
            }

            let sprite = new Image();
            sprite.src ='/img/pokemon_sprite.png';

            sprite.onload = function(){
                ctx.drawImage(sprite, 100, 0, 60, 60, 300, 300, 60, 60);
            }
            let spriteX = 300;
            let spriteY = 300;

            canvas.addEventListener("click", (event) => {
            
                let rect = canvas.getBoundingClientRect();
                let x = event.clientX - rect.left;
                let y = event.clientY - rect.top;

                console.log(x, y);

                if (x > 519 && x < 535){
                    if(y > 594 && y < 604){
                        moveWest();
                    }
                }

                if (x > 596 && x < 607){
                    if(y > 524 && y < 534){
                        moveNorth();
                    }
                }

                if (x > 667 && x < 676){
                    if(y > 594 && y < 605){
                        moveEast();
                    
                    }
                }

                if (x > 598 && x < 610){
                    if(y > 664 && y < 678){
                       moveSouth();
                    }
                }


            });
            
            let feet = true;
            function moveWest(){
                if (feet){
                    console.log("true");
                    ctx.clearRect(spriteX, spriteY, 60, 60);
                    spriteX -=10;
                    ctx.drawImage(sprite, 160, 60, 60, 60, spriteX, spriteY, 60, 60);
                    feet = false;
                }else if(!feet){
                    ctx.clearRect(spriteX, spriteY, 60, 60);
                    spriteX -=10;
                    ctx.drawImage(sprite, 0, 60, 60, 60, spriteX, spriteY, 60, 60);
                    feet = true;
                };
                console.log(room.walls.west);
            }
            function moveNorth(){
                ctx.clearRect(spriteX, spriteY, 60, 60);
                spriteY -=20;
                ctx.drawImage(sprite, 100, 180, 60, 60, spriteX, spriteY, 60, 60);
                console.log(room.walls.north);
            }
            function moveEast(){
                ctx.clearRect(spriteX, spriteY, 60, 60);
                spriteX +=20;
                ctx.drawImage(sprite, 100, 120, 60, 55, spriteX, spriteY, 60, 60);
                console.log(room.walls.east);
            }
            function moveSouth(){
                ctx.clearRect(spriteX, spriteY, 60, 60);
                spriteY +=20;
                ctx.drawImage(sprite, 100, 0, 60, 60, spriteX, spriteY, 60, 60);
                console.log(room.walls.south);
            }

            function drawRoom(room){
                ctx.fillStyle = 'black';

            }
        </script>
    </body>
</html>