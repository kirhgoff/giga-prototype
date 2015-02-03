import com.gigaspaces.annotation.pojo.CompoundSpaceIndex;
import com.gigaspaces.annotation.pojo.CompoundSpaceIndexes;
import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.io.Serializable;
import java.math.BigDecimal;

@CompoundSpaceIndexes({
      @CompoundSpaceIndex(paths = {"info", "info2", "info3"}),
      @CompoundSpaceIndex(paths = {"info5", "info6", "info7", "price2"}),
      @CompoundSpaceIndex(paths = {"price", "info8", "price3", "info9"}),
})
@SpaceClass
public class BigMessage implements Serializable {
  static final long serialVersionUID = 172512L;

  private String id;
  private Integer amount;
  private String info;
  private String info2;
  private String info3;
  private String info4;
  private String info5;
  private String info6;
  private String info7;
  private String info8;
  private String info9;
  private String info10;
  private String info11;
  private String info12;
  private String info13;
  private String info14;
  private String info15;

  private BigDecimal price;
  private BigDecimal price2;
  private BigDecimal price3;
  private BigDecimal price4;
  private BigDecimal price5;
  private BigDecimal price6;
  private BigDecimal price7;
  private BigDecimal price8;
  private BigDecimal price9;
  private BigDecimal price10;
  private BigDecimal price11;
  private BigDecimal price12;
  private BigDecimal price13;
  private BigDecimal price14;
  private BigDecimal price15;
  private BigDecimal price16;
  private BigDecimal price17;
  private BigDecimal price18;
  private BigDecimal price19;
  private BigDecimal price20;
  private BigDecimal price21;
  private BigDecimal price22;
  private BigDecimal price23;

  public BigMessage() {}

  public BigMessage(String id) {
    this.id = id;
  }

  public BigMessage(Integer amount, String info, String info2, String info3, BigDecimal price, BigDecimal price2) {
    this (createId(amount, info, info2, info3, price, price2));
    this.amount = amount;
    this.info = info;
    this.price = price;
  }

  public static String createId(Integer amount, String info, String info2, String info3, BigDecimal price, BigDecimal price2) {
    return amount + "_" + info + "_" + info2 + "_" + info3 + "_"  + price + "_" + price2;
  }

  @SpaceRouting
  @SpaceId
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice11() {
    return price11;
  }

  public void setPrice11(BigDecimal price11) {
    this.price11 = price11;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice12() {
    return price12;
  }

  public void setPrice12(BigDecimal price12) {
    this.price12 = price12;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice13() {
    return price13;
  }

  public void setPrice13(BigDecimal price13) {
    this.price13 = price13;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice14() {
    return price14;
  }

  public void setPrice14(BigDecimal price14) {
    this.price14 = price14;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice15() {
    return price15;
  }

  public void setPrice15(BigDecimal price15) {
    this.price15 = price15;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice16() {
    return price16;
  }

  public void setPrice16(BigDecimal price16) {
    this.price16 = price16;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice17() {
    return price17;
  }

  public void setPrice17(BigDecimal price17) {
    this.price17 = price17;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice18() {
    return price18;
  }

  public void setPrice18(BigDecimal price18) {
    this.price18 = price18;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice19() {
    return price19;
  }

  public void setPrice19(BigDecimal price19) {
    this.price19 = price19;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice20() {
    return price20;
  }

  public void setPrice20(BigDecimal price20) {
    this.price20 = price20;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice21() {
    return price21;
  }

  public void setPrice21(BigDecimal price21) {
    this.price21 = price21;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice22() {
    return price22;
  }

  public void setPrice22(BigDecimal price22) {
    this.price22 = price22;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice23() {
    return price23;
  }

  public void setPrice23(BigDecimal price23) {
    this.price23 = price23;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo2() {
    return info2;
  }

  public void setInfo2(String info2) {
    this.info2 = info2;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo3() {
    return info3;
  }

  public void setInfo3(String info3) {
    this.info3 = info3;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo4() {
    return info4;
  }

  public void setInfo4(String info4) {
    this.info4 = info4;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo5() {
    return info5;
  }

  public void setInfo5(String info5) {
    this.info5 = info5;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo6() {
    return info6;
  }

  public void setInfo6(String info6) {
    this.info6 = info6;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo7() {
    return info7;
  }

  public void setInfo7(String info7) {
    this.info7 = info7;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo8() {
    return info8;
  }

  public void setInfo8(String info8) {
    this.info8 = info8;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo9() {
    return info9;
  }

  public void setInfo9(String info9) {
    this.info9 = info9;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo10() {
    return info10;
  }

  public void setInfo10(String info10) {
    this.info10 = info10;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo11() {
    return info11;
  }

  public void setInfo11(String info11) {
    this.info11 = info11;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo12() {
    return info12;
  }

  public void setInfo12(String info12) {
    this.info12 = info12;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo13() {
    return info13;
  }

  public void setInfo13(String info13) {
    this.info13 = info13;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo14() {
    return info14;
  }

  public void setInfo14(String info14) {
    this.info14 = info14;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public String getInfo15() {
    return info15;
  }

  public void setInfo15(String info15) {
    this.info15 = info15;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
  public BigDecimal getPrice2() {
    return price2;
  }

  public void setPrice2(BigDecimal price2) {
    this.price2 = price2;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice3() {
    return price3;
  }

  public void setPrice3(BigDecimal price3) {
    this.price3 = price3;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice4() {
    return price4;
  }

  public void setPrice4(BigDecimal price4) {
    this.price4 = price4;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice5() {
    return price5;
  }

  public void setPrice5(BigDecimal price5) {
    this.price5 = price5;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice6() {
    return price6;
  }

  public void setPrice6(BigDecimal price6) {
    this.price6 = price6;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice7() {
    return price7;
  }

  public void setPrice7(BigDecimal price7) {
    this.price7 = price7;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice8() {
    return price8;
  }

  public void setPrice8(BigDecimal price8) {
    this.price8 = price8;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice9() {
    return price9;
  }

  public void setPrice9(BigDecimal price9) {
    this.price9 = price9;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice10() {
    return price10;
  }

  public void setPrice10(BigDecimal price10) {
    this.price10 = price10;
  }


  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public Integer getAmount() {
    return amount;
  }

  @SpaceIndex(type= SpaceIndexType.BASIC)
  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @SpaceIndex(type=SpaceIndexType.EXTENDED)
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String toString() {
    return "SmallMessageCompexKey[" + amount + ", " + info + ", " + price + "]";
  }
}