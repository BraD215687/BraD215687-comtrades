package com.comtrades.app;
import android.content.*;import android.graphics.*;import android.view.*;
public class GlassIconView extends View{
 Paint p=new Paint(3); String type;
 public GlassIconView(Context c,String t){super(c);type=t;setLayerType(View.LAYER_TYPE_SOFTWARE,null);}
 protected void onDraw(Canvas c){float w=getWidth(),h=getHeight(),cx=w/2,cy=h/2,r=Math.min(w,h)*.42f,s=r*.58f;
  p.setStyle(Paint.Style.FILL);p.setColor(Color.argb(34,130,255,205));p.setShadowLayer(18,0,7,Color.argb(70,70,255,180));c.drawRoundRect(cx-r,cy-r,cx+r,cy+r,r*.48f,r*.48f,p);p.clearShadowLayer();p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(Math.max(3,w*.045f));p.setStrokeCap(Paint.Cap.ROUND);p.setStrokeJoin(Paint.Join.ROUND);p.setColor(Color.rgb(225,255,242));
  if(type.equals("scan")){c.drawLine(cx-s,cy-s,cx-s*.35f,cy-s,p);c.drawLine(cx-s,cy-s,cx-s,cy-s*.35f,p);c.drawLine(cx+s,cy-s,cx+s*.35f,cy-s,p);c.drawLine(cx+s,cy-s,cx+s,cy-s*.35f,p);c.drawLine(cx-s,cy+s,cx-s*.35f,cy+s,p);c.drawLine(cx-s,cy+s,cx-s,cy+s*.35f,p);c.drawLine(cx+s,cy+s,cx+s*.35f,cy+s,p);c.drawLine(cx+s,cy+s,cx+s,cy+s*.35f,p);p.setColor(Color.rgb(83,226,147));c.drawLine(cx-s*.8f,cy,cx+s*.8f,cy,p);}
  else if(type.equals("draw")){c.drawRect(cx-s*.75f,cy-s*.75f,cx+s*.55f,cy+s*.7f,p);c.drawLine(cx-s*.4f,cy-s*.3f,cx+s*.8f,cy-s*.3f,p);c.drawLine(cx-s*.4f,cy+s*.15f,cx+s*.8f,cy+s*.15f,p);}
  else if(type.equals("work")){c.drawRoundRect(cx-s*.7f,cy-s*.75f,cx+s*.7f,cy+s*.75f,s*.15f,s*.15f,p);Path q=new Path();q.moveTo(cx-s*.4f,cy);q.lineTo(cx-s*.08f,cy+s*.3f);q.lineTo(cx+s*.48f,cy-s*.35f);c.drawPath(q,p);}
  else if(type.equals("issue")){Path q=new Path();q.moveTo(cx,cy-s*.85f);q.lineTo(cx+s*.85f,cy+s*.7f);q.lineTo(cx-s*.85f,cy+s*.7f);q.close();c.drawPath(q,p);c.drawLine(cx,cy-s*.3f,cx,cy+s*.2f,p);c.drawCircle(cx,cy+s*.48f,p.getStrokeWidth()*.35f,p);}
  else if(type.equals("cable")){c.drawCircle(cx-s*.28f,cy,s*.38f,p);c.drawCircle(cx+s*.28f,cy,s*.38f,p);c.drawLine(cx-s*.65f,cy+s*.45f,cx+s*.65f,cy+s*.45f,p);} else {c.drawCircle(cx,cy,s*.65f,p);c.drawCircle(cx,cy,s*.12f,p);}
 }
}
