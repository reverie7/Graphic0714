package game.shooting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import study.graphic0714.R;

/**
 * Created by yj on 2015-07-14.
 */
public class GameView extends View{
    Bitmap ship;
    private int posX;
    private int posY;
    Paint paint;

    /*조이스틱 , 총알버튼의 크기*/
    RectF[] control=new RectF[5];
    int controlWidth=50;
    int controlHeight=50;
    int x=60;
    int y=250;
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
        ship=Bitmap.createScaledBitmap(bitmap, 100, 100, false);
        paint=new Paint();
        paint.setColor(Color.BLUE);

        control[0]=new RectF(x,y,x+controlWidth,y+controlHeight);/*위*/
        control[1]=new RectF(x,y+2*controlHeight,x+controlWidth,y+2*controlHeight+controlHeight);/*아래*/
        control[2]=new RectF(x-controlWidth,y+controlHeight,(x-controlWidth)+controlWidth,(y+controlHeight)+controlHeight);/*왼쪽*/
        control[3]=new RectF(x+controlWidth,y+controlHeight,(x+controlWidth)+controlWidth,(y+controlHeight)+controlHeight);/*오른쪽*/
        control[4]=new RectF(100,200,100+controlWidth,100+controlHeight);/*발사*/
    }
    /*조이스틱 그리기*/
    public void paintJoystick(Canvas canvas){

        for (int i=0; i<4;i++){
            canvas.drawRect(control[i],paint);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(ship, posX, posY, null);
        paintJoystick(canvas);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
