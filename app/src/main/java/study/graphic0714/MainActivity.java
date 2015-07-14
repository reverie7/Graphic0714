package study.graphic0714;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    ArrayList<Point> list = new ArrayList<Point>();
    String TAG;
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TAG = this.getClass().getName();
        myView = (MyView) findViewById(R.id.MyView);
    }

    public void printOval(ArrayList list) {
        /*������ ��ǥ�� �̿��Ͽ� MyView �ٽ� �׸���*/
        myView.list = list;
        myView.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        /*��ġ�� �߻��ϸ� ��ǥ�� �÷��� ��ü�� ����*/
        Point point = new Point((int) event.getX(), (int) event.getY());
        list.add(point);
        printOval(list);
        return false;
    }
}
