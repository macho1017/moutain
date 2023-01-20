/**
 * Canvas 内をボールが反射しながら飛び回るプログラム
 * このクラスでは、主に次のような下準備を行う。
 *   1. main() によるプログラムの開始
 *   2. フレームの作成
 *   3. スレッドの逐次進行設定
 * 描画内容の詳細は GameMaster クラス内で行う
 *
 * @author fukai
 */

import java.awt.*;

public class AnimBall extends Frame implements Runnable {
  // ■ フィールド変数
  Thread th; // スレッドオブジェクトの宣言
  GameMaster gm; // ゲームの進行全般を担うオブジェクトの宣言

  // ■ main メソッド（スタート地点）
  public static void main(String[] args) {
    AnimBall ab = new AnimBall(); // 自分自身のオブジェクトを作成
  }

  // ■ コンストラクタ（初期化メソッド）
  AnimBall(){
    // フレームの作成 (Frameクラス)
    super("Ball Animation"); // 親クラス (Frame) のコンストラクタを呼び出す
    int cW=320, cH=240;      // キャンバスのサイズ
    this.setSize(cW, cH);    // フレームのサイズ指定
    this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // レイアウト指定

    // ゲームの進行全般を担うオブジェクト作成 (GameMasterクラス)
    gm = new GameMaster(cW,cH);// キャンバスのオブジェクト（主の画用紙）を作成
    this.add(gm);            // キャンバスをフレームに配置
    this.setVisible(true);   // 可視化

    // 逐次更新用オブジェクトの作成 (Threadクラス)
    th = new Thread(this); // スレッドのオブジェクトの作成
    th.start();            // スレッドを start メソッドで開始
  }

  // ■ メソッド（Runnable)
  public void run() {  // スレッドにより実行される
    try {
      while(true) {   // 無限ループ
    th.sleep(40); // 再描画する前に一定時間休止
    gm.repaint(); // 再描画を要求する repaint() は update() を呼び出す
      }
    }
    catch(Exception e) { // 例外処理
      System.err.println( "エラーが発生しました: " + e );
    }
  }
}