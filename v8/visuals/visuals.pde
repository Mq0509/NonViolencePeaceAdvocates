PImage uno;
int screen;
void setup(){
  size(1200,900);
  uno = loadImage("starting.png");
  uno.resize(1000,750);
  screen = 0;
}

void draw(){
  background(247);
  if(screen == 0){
  image(uno, 100, 0);
  fill(255, 26, 26);
  rect(width/2 - 125, 750, 250, 75);
  fill(10,0,0);
  textSize(35);
  text("MENU",560,800);
}
 else if(screen == 1){
   background(192,139,219);
   fill(255, 26, 26);
   rect(150, 413, 200, 75);
   fill(10,0,0);
   text("START",210,465);
   fill(255, 26, 26);
   rect(500, 413, 200, 75);
   fill(10,0,0);
   text("TUTORIAL",530,465);
   fill(255, 26, 26);
   rect(850, 413, 200, 75);
   fill(10,0,0);
   text("QUIT",900,465);
 }
  else if(screen == 2){
  print("hi");
 }
 else if(screen == 3){
        text("The ", 0, 0);
        text("OBJECTIVE",10, 0);
        text("is to clear all of your cards.",20, 0);
        text("Players can put down a card of the same color or number",0,0);
        text("If player does not have any card, they must take one card from the deck",0,0);
        text("Special cards include: reverse, add 2, add 4, wild, and skip. ",0,0);
        text("If player does not have any card, they must take one card from the deck",0,0);
        text("Add 2 may be placed on a add 4 if the color of the plus 4 is the same color of the plus 2",0,0);
        text("Once player has one card left, player must type uno or UNO into the terminal within 3 seconds",0,0);
        text("Player must type UNO-OUT or uno-out within 5 seconds inside the terminal once player has no cards",0,0);
        text("If player does not type into the terminal in the designated time, player will recieve 1 card",0,0);
        text("Type ready to continue",0,0);
 }
}

void mousePressed(){
  if(screen == 0){
  if(hoveringButton(width/2 - 125, 750, 250, 75)){
    screen = 1;
  }
  else if(screen == 1){
  if(hoveringButton(150, 413, 200, 75)){
    screen = 2;
  }
  if(hoveringButton(500, 413, 200, 75)){
    screen = 3;
  }
  if(hoveringButton(850, 413, 200, 75)){
   exit();
  }
  }
}
}
  

boolean hoveringButton(int x, int y, int rectWidth, int rectHeight) {
  if (mouseX >= x && mouseX <= x+rectWidth && 
    mouseY >= y && mouseY <= y+rectHeight) {
    return true;
  } else {
    return false;
  }
}
