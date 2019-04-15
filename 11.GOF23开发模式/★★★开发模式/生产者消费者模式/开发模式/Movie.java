package ����ģʽ;
/**
 * �ص㣺һ������,��ͬ����Դ
 * ������������ģʽ���źŵƷ�
 	*	1).wait()�ȴ������ͷ�����sleep���ͷ�����
 	*	2).notify/notifyAll����
 	*	3).��synchronized��ͬʹ��
 */
public class Movie {
	private String pic;//���ŵĶ���
	/*
	 * �źŵ�
	 * flag-->trueʱ �����������������ߵȴ�,������ɺ�֪ͨ����
	 * flag-->falseʱ ���������ѣ������ߵȴ���������ɺ� ֪ͨ����
	 */
	private boolean flag=true;
	
	
	public synchronized  void play(String pic) {
		if(!flag) {//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������->"+pic);
		//�������
		this.pic=pic;
		//֪ͨ����
		this.notify();
		//������Ҫͣ��
		this.flag=false;
	}
	public synchronized void watch() {
		if(flag) {//�����ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��ʼ����
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������--��"+pic);
		//�������
		//֪ͨ����
		this.notify();
		//����ֹͣ
		this.flag=true;
		
	}
	public static void main(String[] args) {
		//��ͬ����Դ
		Movie m = new Movie();
		//���߳�
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		//���������߳�
		new Thread(p).start();
		new Thread(w).start();
		
	}
}


/* ������*/
class Player implements Runnable {
	private Movie m;
	
	public Player(Movie m) {super();this.m = m;}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if(0==i%2) {
				m.play("������");
			}else {
				m.play("�Ұ׻�");
			}
		}
	}

}
/*������ */
class Watcher implements Runnable {
	private Movie m;
	
	public Watcher(Movie m) {super();this.m = m;}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			m.watch();
		}
	}

}

