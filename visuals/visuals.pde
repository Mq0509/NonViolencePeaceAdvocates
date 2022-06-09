int screen;
PImage uno;
PImage bboard;
PFont font;
boolean ran;
boolean typing;
String name;
Mesa Mesa;
PImage Red_0;
PImage Red_1;
PImage Red_2;
PImage Red_3;
PImage Red_4;
PImage Red_5;
PImage Red_6;
PImage Red_7;
PImage Red_8;
PImage Red_9;
PImage Yellow_0;
PImage Yellow_1;
PImage Yellow_2;
PImage Yellow_3;
PImage Yellow_4;
PImage Yellow_5;
PImage Yellow_6;
PImage Yellow_7;
PImage Yellow_8;
PImage Yellow_9;
PImage Green_0;
PImage Green_1;
PImage Green_2;
PImage Green_3;
PImage Green_4;
PImage Green_5;
PImage Green_6;
PImage Green_7;
PImage Green_8;
PImage Green_9;
PImage Blue_9;
PImage Blue_8;
PImage Blue_7;
PImage Blue_6;
PImage Blue_5;
PImage Blue_4;
PImage Blue_3;
PImage Blue_2;
PImage Blue_1;
PImage Blue_0;
PImage Blue_Skip;
PImage Green_Skip;
PImage Yellow_Skip;
PImage Red_Skip;
PImage Red_Draw;
PImage Yellow_Draw;
PImage Green_Draw;
PImage Blue_Draw;
PImage Yellow_Reverse;
PImage Red_Reverse;
PImage Green_Reverse;
PImage Blue_Reverse;
PImage Wild_Draw;
PImage Wild_;

    // System.out.println("Topmost card: " + newGame.getTop());

  //  newGame.go();
  //}
  
void setup() {
  size(1200, 900);
  uno = loadImage("starting.png");
  uno.resize(1000, 750);
  bboard = loadImage("blackboard.png");
  bboard.resize(1200, 900);
  screen = 0;
  ran = false;
  typing = false;
  name = "";
  Red_0 = loadImage("Red_0.png");
  Red_1 = loadImage("Red_1.png");
  Red_2 = loadImage("Red_2.png");
  Red_3 = loadImage("Red_3.png");
  Red_4 = loadImage("Red_4.png");
  Red_5 = loadImage("Red_5.png");
  Red_6 = loadImage("Red_6.png");
  Red_7 = loadImage("Red_7.png");
  Red_8 = loadImage("Red_8.png");
  Red_9 = loadImage("Red_9.png");
  Yellow_0 = loadImage("Yellow_0.png");
  Yellow_1 = loadImage("Yellow_1.png");
  Yellow_2 = loadImage("Yellow_2.png");
  Yellow_3 = loadImage("Yellow_3.png");
  Yellow_4 = loadImage("Yellow_4.png");
  Yellow_5 = loadImage("Yellow_5.png");
  Yellow_6 = loadImage("Yellow_6.png");
  Yellow_7 = loadImage("Yellow_7.png");
  Yellow_8 = loadImage("Yellow_8.png");
  Yellow_9 = loadImage("Yellow_9.png");
  Green_0 = loadImage("Green_0.png");
  Green_1 = loadImage("Green_1.png");
  Green_2 = loadImage("Green_2.png");
  Green_3 = loadImage("Green_3.png");
  Green_4 = loadImage("Green_4.png");
  Green_5 = loadImage("Green_5.png");
  Green_6 = loadImage("Green_6.png");
  Green_7 = loadImage("Green_7.png");
  Green_8 = loadImage("Green_8.png");
  Green_9 = loadImage("Green_9.png");
  Blue_9 = loadImage("Blue_9.png");
  Blue_8 = loadImage("Blue_8.png");
  Blue_7 = loadImage("Blue_7.png");
  Blue_6 = loadImage("Blue_6.png");
  Blue_5 = loadImage("Blue_5.png");
  Blue_4 = loadImage("Blue_4.png");
  Blue_3 = loadImage("Blue_3.png");
  Blue_2 = loadImage("Blue_2.png");
  Blue_1 = loadImage("Blue_1.png");
  Blue_0 = loadImage("Blue_0.png");
  Blue_Skip = loadImage("Blue_Skip.png");
  Green_Skip = loadImage("Green_Skip.png");
  Yellow_Skip = loadImage("Yellow_Skip.png");
  Red_Skip = loadImage("Red_Skip.png");
  Red_Draw = loadImage("Red_Draw.png");
  Yellow_Draw = loadImage("Yellow_Draw.png");
  Green_Draw = loadImage("Green_Draw.png");
  Blue_Draw = loadImage("Blue_Draw.png");
  Yellow_Reverse = loadImage("Yellow_Reverse.png");
  Red_Reverse = loadImage("Red_Reverse.png");
  Green_Reverse = loadImage("Green_Reverse.png");
  Blue_Reverse = loadImage("Blue_Reverse.png");
  Wild_Draw = loadImage("Wild_Draw.png");
  Wild_ = loadImage("Wild_.png");
}

void draw() {
  background(247);
  if (screen == 0) {
    image(uno, 100, 0);
    fill(255, 26, 26);
    rect(width/2 - 125, 750, 250, 75);
    fill(10, 0, 0);
    textSize(35);
    text("MENU", 560, 800);
  } else if (screen == 1) {
    background(192, 139, 219);
    fill(255, 26, 26);
    rect(150, 413, 200, 75);
    fill(10, 0, 0);
    text("START", 210, 465);
    fill(255, 26, 26);
    rect(500, 413, 200, 75);
    fill(10, 0, 0);
    text("TUTORIAL", 530, 465);
    fill(255, 26, 26);
    rect(850, 413, 200, 75);
    fill(10, 0, 0);
    text("QUIT", 900, 465);
  } 
  else if (screen == 2) {
    textSize(40);
    text("Cual es tu nombre?",500,450);
    fill(255);
    rect(width/2 - 250, height/2 - 50, 500, 100);
    fill(0);
    text(name, width/2 - 250, height/2 - 100);
    fill(255, 26, 26);
    rect(width/2 - 250, height/2 + 175, 500, 100);
    fill(10, 0, 0);
    text("NEXT", width/2 - 250, height/2 + 175);
  }
   else if (screen == 3) {
    font = createFont("Karumbi", 128);
    textFont(font);
    image(bboard, 0, 0);
    textSize(20);
    fill(255, 255, 255);
    text("The ", 0, 100);
    fill(255, 26, 26);
    text("OBJECTIVE", 70, 100);
    fill(255, 255, 255);
    text("is to clear all of your cards.", 250, 100);
    text("Players can put down a card of the same color or number", 0, 150);
    text("If player does not have any card, they must take one card from the deck", 0, 200);
    text("Special cards include: reverse, add 2, add 4, wild, and skip. ", 0, 250);
    text("If player does not have any card, they must take one card from the deck", 0, 300);
    text("Add 2 may be placed on a add 4 if the color of the plus 4 is the same color of the plus 2", 0, 350);
    text("Once player has one card left, player must type uno or UNO into the terminal within 3 seconds", 0, 400);
    text("Player must type UNO-OUT or uno-out within 5 seconds inside the terminal once player has no cards", 0, 450);
    text("If player does not type into the terminal in the designated time, player will recieve 1 card", 0, 500);
    text("Press ready to continue", 0, 550);
    fill(255, 26, 26);
    rect(width/2 - 125, 700, 200, 75);
    fill(10, 0, 0);
    textSize(35);
    text("READY", width/2 -75, 750);
  }
  else if(screen == 4){
      if (ran == false) {
      Player p1 = new Human(name);
      Player p2 = new Bot("Kenny");
      Player p3 = new Bot("Rachel");
      Player p4 = new Bot("Bob The Builder");
      Mesa newGame = new Mesa(p1,p2,p3,p4);
      newGame.placeFirst();
      newGame.distribute();
      ran = true;
      newGame.go();
    }
    
  }
}
void keyPressed() {
  if (typing) {
    if (key == BACKSPACE) {
      name = name.substring(0,name.length()-1);
    }
    if ((key >= 'a' && key <= 'z') || (key >= 'A' && key <= 'Z')) {
      name += key;
    }
  }
}
void mousePressed() {
  if (screen == 0) {
    if (hoveringButton(width/2 - 125, 750, 250, 75)) {
      screen = 1;
    }
  } 
  else if (screen == 1) {
    if (hoveringButton(150, 413, 200, 75)) {
      screen = 2;
    }
    if (hoveringButton(500, 413, 200, 75)) {
      screen = 3;
    }
    if (hoveringButton(850, 413, 200, 75)) {
      exit();
    }
  } 
  else if (screen == 2){
    if(hoveringButton(width/2 - 250, height/2 - 50, 500, 100)){
      typing = true;
    }
    else if(hoveringButton(width/2 - 250, height/2 + 175, 500, 100)){
      screen = 4;
      typing = false;
    }
    //else{
    //  typing = false;
    //}
  }
  else if (screen == 3) {
    if (hoveringButton(width/2 - 125, 700, 200, 75)) {
      screen = 2;
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
