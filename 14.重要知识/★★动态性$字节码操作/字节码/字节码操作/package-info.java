/**
 * Java�ֽ����������̬�����������ֽ�������Ҳ�����÷�������
 * Java��̬�Ե����ֳ���ʵ�ַ���
 * --�ֽ������
 * --����
 * 
 * ����ʱ�����ֽ������������ʵ�����¹���
 * --�����µ��࣬����˵������һ�������һ����������ֱ��дһ����Ĵ����ַ�����Ȼ��ֱ������һ��.class�ļ���
 * --��̬�ı�ĳ����Ľṹ�����/ɾ��/�޸� �µ�����/������
 * 
 * �ŵ�
 * --�ȷ��俪��С�����ܸ�
 * --JAVAassist���ܸ��ڷ��䣬����ASM
 * 
 * 
 *.java-->.class-->jvm����class�ļ�(os)����ν���ֽ���������ǲ���jvm������غõ����ļ�
 *
 *
 *�������ֽ���������(BCEL��ASM���)
 *	BCEL
 *	--Byte Code Engineering Library(BCEL),����Apache Software Foundation��Jakarta��Ŀ��һ���֣�BCEL
 *��Java classworking�㷺ʹ�õ�һ�ֿ�ܣ���������������JVM������Խ����������ϸ�ڣ�BCEL��Javaassist�в�ͬ�Ĵ����ֽ���
 *�ķ�����BCEL��ʵ�ʵ�JVMָ�����Ͻ��в�����BCELӵ�зḻ��JVMָ�֧�ֶ�Javaassist��ǿ���ľ���Դ���뼶��Ĺ���
  
 *ASM
 *--��һ��������Java�ֽ��������ܣ�ֱ���漰��JVM�ײ�Ĳ�����ָ��
  
 *CGLIB(Code Generation Library)
 *--��һ��ǿ��ģ������ܣ���������Code������⣬����ASMʵ��
  
 *Javassist
 *--��һ����Դ�ķ������༭�ʹ���java�ֽ������⣬���ܽ�ASM���cglib��࣬����ʹ�ü򵥣��ܶ࿪Դ��ܶ�������
 
 *
 *Aspect Oriented Programming ������������
 *
 *							javassist��������API		����ִ�к�JDK����API��
 *  			  			  ����Ҫ��CtClass------->>>java.lang.Class
 *               			 CtMethod------------>>>java.lang.reflect.Method
 *              			 CtField���������	----->>>java.lang.reflect.Method.Field
 *��ͬ�Ĳ���
 *
 *�����ԣ�
 *--JDK5.0���﷨��֧�֣��������ͣ�ö�٣� ��֧��ע���޸ģ�������ͨ���ײ��javassist�������������ο�javassist.bytecode.annotation
 *--��֧������ĳ�ʼ�����磺String[]{"1","2"},����ֻ�����������Ϊ1
 *--��֧���ڲ����������
 *--��֧��continue��break���ʽ
 *--���ڼ̳й�ϵ����Щ��֧�֣�����
 *----class A{}
 *----class B extends A{}
 *----class C extends B{}
 */
package �ֽ������;