package com.redknot.thread;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;

import com.redknot.g.Dragon;
import com.redknot.g.Fractint;
import com.redknot.g.Hualan;
import com.redknot.g.Huangguan;
import com.redknot.g.Koch;
import com.redknot.g.Landform;
import com.redknot.g.Leaf;
import com.redknot.g.Levy;
import com.redknot.g.MountainView;
import com.redknot.g.Newton;
import com.redknot.g.Sierpinski;
import com.redknot.g.Stone;
import com.redknot.g.Tree;
import com.redknot.util.ID;

public class DrawMainThread implements Runnable {

	private SurfaceHolder holder;
	private int width;
	private int height;
	private int color;
	private int id;
	private int n;
	private Handler handler;

	public DrawMainThread(Handler handler,SurfaceHolder holder, int width, int height,
			int color, int id, int n) {
		this.holder = holder;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
		this.n = n;
		this.handler = handler;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			synchronized (holder) {
				Paint p = new Paint();
				p.setColor(this.color);
				p.setStyle(Style.STROKE);
				
				if (this.id == ID.KOCH1) {
					Koch k = new Koch();
					k.koch1(0, this.height / 2, this.width, this.height / 2,
							this.n, holder, path, p);
				} else if (this.id == ID.KOCH2) {
					Koch k = new Koch();
					k.koch2(0, this.height / 2, this.width, this.height / 2,
							this.n, holder, path, p);
				} else if (this.id == ID.HUALAN) {
					Hualan h = new Hualan();
					h.hualan(0, this.height / 2, this.width, this.height / 2,
							n, holder, path, p);
				} else if (this.id == ID.HUANGGUAN) {
					Huangguan h = new Huangguan();
					h.huangguan(0, this.height / 2, this.width,
							this.height / 2, n, holder, path, p);
				} else if (this.id == ID.LEVY) {
					Levy l = new Levy();
					l.levy(0 + 200, this.height / 2, this.width - 200,
							this.height / 2, n, holder, path, p);
				}

				else if (this.id == ID.SIERPINSKI) {
					Sierpinski s = new Sierpinski();
					int x1 = this.width / 2;
					int y1 = this.height / 2 + 200
							- (int) (Math.sqrt(3) * (this.width / 2));
					int x2 = 0;
					int y2 = this.height / 2 + 200;
					int x3 = this.width;
					int y3 = this.height / 2 + 200;
					s.sier_gasket(x1, y1, x3, y3, x2, y2, n, holder, path, p);
				}

				else if (this.id == ID.TREE) {
					Tree t = new Tree();
					t.tree1(0, this.height / 2, this.width, this.height / 2, n,
							holder, path, p);
				}
				
				else if (this.id == ID.MOUNTAIN) {
					MountainView v = new MountainView();
					v.mountain(holder, p);
				}
				
				else if (this.id == ID.LEAF) {
					Leaf f = new Leaf();
					f.leaf(holder, p);
				}
				else if (this.id == ID.STONE) {
					Stone s = new Stone();
					s.stone(holder, p);
				}
				
				else if (this.id == ID.DRAGON) {
					Dragon d = new Dragon();
					d.dragon(holder, p);
				}
				else if (this.id == ID.FRACTAL) {
					Fractint f = new Fractint();
					f.fractint(holder, p);
				}
				else if (this.id == ID.LANDFROM) {
					Landform l =new Landform();
					l.landform(holder, p);
				}
				
				else if (this.id == ID.NEWTON) {
					Newton n = new Newton();
					n.newton(3, 7, holder, p);
				}
				
				//Toast.makeText(context, "complete", Toast.LENGTH_LONG).show();
			}
			// (0, this.height/2, this.width, this.height/2, 5, holder, path,p);
		} catch (Exception e) {

		}finally{
			Message msg = new Message();
			msg.what = 200;
			this.handler.sendMessage(msg);
		}

	}

	Path path = new Path();

}
