import java.awt.*;
class Shape { 
  /*■■■ フィールド変数部 ■■■*/
  int x, y;    // 位置
  int dx, dy;  // 速度
  int color;   // 色
  int r;       // 半径
  boolean rebound;//色を変えるか判断する
  int R,G,B;
  
  /*■■■ コンストラクタ部 ■■■*/
  Shape () { // 引数が無い場合のデフォルト値
    x = y = 200;
    dx = dy = 2;
  }
 public void update (int width, int height){ // オブジェクトのパラメータの更新
    rebound = false;
    if (x >= width)  {
        dx=dx*(-1);     // 右端に当たったときの処理
        rebound=true;
    }
    if (x <= 0)   {
        dx=dx*(-1);    // 左端に当たったときの処理
        rebound=true;
    }
    if (y >= height)  {
        dy=dy*(-1);     // 下端に当たったときの処理
        rebound=true;
    }
    if (y <= 0)      {
        dy=dy*(-1);     // 上端に当たったときの処理
        rebound=true;
    }
    x=x+dx;                          // x 座標の更新
    y=y+dy;                          // y 座標の更新
  }
}

class Maru extends Shape{
    int r;
    int R=255;
    int G=0;
    int B=0;
    Maru(){
        r=8;
    }
    Maru (int x, int y, int dx, int dy){  // 引数がある場合（メソッドオーバーロード）
        r=8;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
      }

  /*■■■ メソッド部 ■■■*/
  public void draw(Graphics g){ // サブ画用紙 (buf) の GC (buf_gc) が引数 // 色を設定
    if(rebound){
        this.R=(int)(Math.random()*256);
        this.G=(int)(Math.random()*256);
        this.B=(int)(Math.random()*256);
    }
        g.setColor(new Color(R,G,B));

    g.drawOval(x-r, y-r, 2*r, 2*r); // ○の描画
  }
}
class FilledMaru extends Maru{
    int r;
    FilledMaru(){
        r=10;
    }
    FilledMaru(int x,int y,int dx ,int dy){
        r=10;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }
    public void draw(Graphics g){ // サブ画用紙 (buf) の GC (buf_gc) が引数 // 色を設定
        if(rebound){
            this.R=(int)(Math.random()*256);
            this.G=(int)(Math.random()*256);
            this.B=(int)(Math.random()*256);
        }
            g.setColor(new Color(R,G,B));
            g.fillOval(x-r,y-r,2*r,2*r);
    }
}

class Sikaku extends Shape{
    int wide;
    int high;
    Sikaku(){
        wide=20;
        high=20;
    }
    Sikaku(int x,int y,int dx,int dy){
        wide=20;
        high=20;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        g.drawRect(x-wide/2, y-high/2, wide, high);
    }
}

class FilledSikaku extends Shape{
    int wide;
    int high;
    int R=0;
    int G=255;
    int B=0;
    FilledSikaku(){
        wide=20;
        high=20;
    }
    FilledSikaku(int x,int y,int dx,int dy){
        wide=20;
        high=20;
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
    }
    public void draw(Graphics g){
        if(rebound){
            this.R=(int)(Math.random()*256);
            this.G=(int)(Math.random()*256);
            this.B=(int)(Math.random()*256);
        }
            g.setColor(new Color(R,G,B));
        g.fillRect(x-wide/2, y-high/2, wide, high);
    }
}