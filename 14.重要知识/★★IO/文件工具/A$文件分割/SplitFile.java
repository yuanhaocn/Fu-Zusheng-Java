package A$�ļ��ָ�;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cn.fzs.io.util.FileUtil;
public class SplitFile {
	//�ļ���·��
	private String filePath;
	//�ļ���
	private String fileName;
	//�ļ���С
	private long length;
	//����
	private int size;
	//ÿ��Ĵ�С
	private long blockSize;
	//�ָ��Ĵ��Ŀ¼
	private String destBlockPath;
	//ÿ�������
	private List<String> blockPath;
	
	public SplitFile(){
		blockPath = new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath){
		this(filePath,destBlockPath,1024);		
	}
	public SplitFile(String filePath,String destBlockPath,long blockSize){
		this();
		this.filePath= filePath;
		this.destBlockPath =destBlockPath;
		this.blockSize=blockSize;
		init();
	}
	
	/**
	 * ��ʼ������ ���� ������ȷ���ļ���
	 */
	public void init(){
		File src =null;
		//��׳��
		if(null==filePath ||!(((src=new File(filePath)).exists()))){
			return;
		}
		if(src.isDirectory()){
			return ;
		}
		//�ļ���
		this.fileName =src.getName();
		
		//������� ʵ�ʴ�С ��ÿ���С
		this.length = src.length();
		//���� ÿ���С
		if(this.blockSize>length){
			this.blockSize =length;
		}
		//ȷ������		
		size= (int)(Math.ceil(length*1.0/this.blockSize));
		//ȷ���ļ���·��
		initPathName();
	}
	
	private void initPathName(){
		for(int i=0;i<size;i++){
			this.blockPath.add(destBlockPath+"/"+this.fileName+".part"+i);
		}
	}
	
	/**
	 * �ļ��ķָ�
	 * 0)���ڼ���
	 * 1����ʼλ��
	 * 2��ʵ�ʴ�С
	 * @param destPath �ָ��ļ����Ŀ¼
	 */
	public void split(){	
		long beginPos =0;  //��ʼ��
		long actualBlockSize =blockSize; //ʵ�ʴ�С		
		//�������п�Ĵ�С��λ�á�����
		for(int i=0;i<size;i++){
			if(i==size-1){ //���һ��
				actualBlockSize =this.length-beginPos;
			}			
			spiltDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize; //���ε��յ㣬��һ�ε����
		}
		
	}
	/**
	 * �ļ��ķָ� ���� ���
	 * �ļ�����
	 * @param idx �ڼ���
	 * @param beginPos ��ʼ��
	 * @param actualBlockSize ʵ�ʴ�С
	 */
	private void spiltDetail(int idx,long beginPos,long actualBlockSize){
		//1������Դ
		File src = new File(this.filePath);  //Դ�ļ�
		File dest = new File(this.blockPath.get(idx)); //Ŀ���ļ�
		//2��ѡ����
		RandomAccessFile raf = null;  //������
		BufferedOutputStream bos=null; //�����
		try {
			raf=new RandomAccessFile(src,"r");
			bos =new BufferedOutputStream(new FileOutputStream(dest));
			
			//��ȡ�ļ�
			raf.seek(beginPos);
			//������
			byte[] flush = new byte[1024];
			//���ճ���
			int len =0;
			while(-1!=(len=raf.read(flush))){				
				if(actualBlockSize-len>=0){ //�鿴�Ƿ��㹻
					//д��
					bos.write(flush, 0, len);
					actualBlockSize-=len; //ʣ����
				}else{ //д�����һ�ε�ʣ����
					bos.write(flush, 0, (int)actualBlockSize);
					break;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			FileUtil.close(bos,raf);
		}
		
	}
	/**
	 * �ļ��ĺϲ�
	 */
	public void merge(String destPath){
		//����Դ
		File dest =new File(destPath);
		//ѡ����
		BufferedOutputStream bos=null; //�����
		SequenceInputStream sis =null ;//������
		//����һ������
		Vector<InputStream> vi = new Vector<InputStream>();		
		try {
			for (int i = 0; i < this.blockPath.size(); i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}	
			bos =new BufferedOutputStream(new FileOutputStream(dest,true)); //׷��
			sis=new SequenceInputStream(vi.elements());			
				
			//������
			byte[] flush = new byte[1024];
			//���ճ���
			int len =0;
			while(-1!=(len=sis.read(flush))){						
				bos.write(flush, 0, len);
			}
			bos.flush();
			FileUtil.close(sis);
		} catch (Exception e) {
		}finally{
			FileUtil.close(bos);
		}		
		
	}
	/**
	 * �ļ��ĺϲ�
	 */
	public void merge1(String destPath){
		//����Դ
		File dest =new File(destPath);
		//ѡ����
		BufferedOutputStream bos=null; //�����
		try {
			bos =new BufferedOutputStream(new FileOutputStream(dest,true)); //׷��
			BufferedInputStream bis = null;
			for (int i = 0; i < this.blockPath.size(); i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
				
				//������
				byte[] flush = new byte[1024];
				//���ճ���
				int len =0;
				while(-1!=(len=bis.read(flush))){						
					bos.write(flush, 0, len);
				}
				bos.flush();
				FileUtil.close(bis);
			}
		} catch (Exception e) {
		}finally{
			FileUtil.close(bos);
		}		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SplitFile split = new SplitFile("E:/xp/20130502/test/ѧԱ����(20130502).xls","E:/xp/20130502",51);
		
		//System.out.println(split.size);
		
		//split.split();
		
		split.merge("E:/xp/20130502/test1.xls");
	}

}
