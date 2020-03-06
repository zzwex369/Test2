
package com.xyw.client.henan;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.xyw.client.henan package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ZfclResponse_QNAME = new QName("http://www.xywdzkj.com/csyxzm/", "zfclResponse");
    private final static QName _ZfRequest_QNAME = new QName("http://www.xywdzkj.com/csyxzm/", "zfRequest");
    private final static QName _ZfclRequest_QNAME = new QName("http://www.xywdzkj.com/csyxzm/", "zfclRequest");
    private final static QName _ZfResponse_QNAME = new QName("http://www.xywdzkj.com/csyxzm/", "zfResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.xyw.client.henan
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FpResponse }
     * 
     */
    public FpResponse createFpResponse() {
        return new FpResponse();
    }

    /**
     * Create an instance of {@link ZfResponse }
     * 
     */
    public ZfResponse createZfResponse() {
        return new ZfResponse();
    }

    /**
     * Create an instance of {@link FmResponse }
     * 
     */
    public FmResponse createFmResponse() {
        return new FmResponse();
    }

    /**
     * Create an instance of {@link SfbResponse }
     * 
     */
    public SfbResponse createSfbResponse() {
        return new SfbResponse();
    }

    /**
     * Create an instance of {@link RkResponse }
     * 
     */
    public RkResponse createRkResponse() {
        return new RkResponse();
    }

    /**
     * Create an instance of {@link DjResponse }
     * 
     */
    public DjResponse createDjResponse() {
        return new DjResponse();
    }

    /**
     * Create an instance of {@link Fp }
     * 
     */
    public Fp createFp() {
        return new Fp();
    }

    /**
     * Create an instance of {@link BfbResponse }
     * 
     */
    public BfbResponse createBfbResponse() {
        return new BfbResponse();
    }

    /**
     * Create an instance of {@link Zf }
     * 
     */
    public Zf createZf() {
        return new Zf();
    }

    /**
     * Create an instance of {@link Dj }
     * 
     */
    public Dj createDj() {
        return new Dj();
    }

    /**
     * Create an instance of {@link Fm }
     * 
     */
    public Fm createFm() {
        return new Fm();
    }

    /**
     * Create an instance of {@link Sfb }
     * 
     */
    public Sfb createSfb() {
        return new Sfb();
    }

    /**
     * Create an instance of {@link Bfb }
     * 
     */
    public Bfb createBfb() {
        return new Bfb();
    }

    /**
     * Create an instance of {@link Rk }
     * 
     */
    public Rk createRk() {
        return new Rk();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xywdzkj.com/csyxzm/", name = "zfclResponse")
    public JAXBElement<ZfResponse> createZfclResponse(ZfResponse value) {
        return new JAXBElement<ZfResponse>(_ZfclResponse_QNAME, ZfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xywdzkj.com/csyxzm/", name = "zfRequest")
    public JAXBElement<Zf> createZfRequest(Zf value) {
        return new JAXBElement<Zf>(_ZfRequest_QNAME, Zf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Zf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xywdzkj.com/csyxzm/", name = "zfclRequest")
    public JAXBElement<Zf> createZfclRequest(Zf value) {
        return new JAXBElement<Zf>(_ZfclRequest_QNAME, Zf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ZfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.xywdzkj.com/csyxzm/", name = "zfResponse")
    public JAXBElement<ZfResponse> createZfResponse(ZfResponse value) {
        return new JAXBElement<ZfResponse>(_ZfResponse_QNAME, ZfResponse.class, null, value);
    }

}
