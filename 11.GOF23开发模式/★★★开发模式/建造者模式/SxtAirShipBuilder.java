
public class SxtAirShipBuilder implements AirShipBuilder {
	//StringBuilder, �Ժ�ѧϰXML�����У�JDOM���е��ࣺDomBuilder,SaxBuilder
	@Override
	public Engine builderEngine() {
		System.out.println("������ѧ���Ʒ�������");
		return new Engine("��ѧ���Ʒ�������");
	}

	@Override
	public EscapeTower builderEscapeTower() {
		System.out.println("����������");
		return new EscapeTower("��ѧ����������");
	}

	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("���������");
		return new OrbitalModule("��ѧ���ƹ����");
	}	
	
}
