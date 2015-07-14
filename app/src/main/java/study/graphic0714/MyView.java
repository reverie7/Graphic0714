package study.graphic0714;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ڰ� ȭ���� ��ġ�ϸ� MyView�� ���� ��ġ�� ��ǥ���� ���ؼ�, �� ����Ʈ�� ���� �׷�����
 */
public class MyView extends View {
    ArrayList<Point> list=new ArrayList<>();
    int width=50;
    int height=50;
    Paint paint;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*���� �׸���*/
        //canvas.drawOval(posX,posY,posX+width,posY+height,null);
        for (int i=0; i<list.size(); i++){
            Point point=list.get(i);
            canvas.drawOval(new RectF(point.x, point.y, point.x+ width, point.y+ height), paint);
        }
    }
}
