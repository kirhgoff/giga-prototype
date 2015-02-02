import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.math.BigDecimal;
import java.io.Serializable;

@SpaceClass
public class SmallMessage implements Serializable {
  static final long serialVersionUID = 162512L;

  private Integer id;
  private String info;
  private BigDecimal price;

  public SmallMessage() {}

  public SmallMessage (Integer id, String info, BigDecimal price) {
    this.id = id;
    this.info = info;
    this.price = price;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @SpaceRouting
  @SpaceId
  public Integer getId() {
    return id;
  }

  @SpaceIndex(type=SpaceIndexType.BASIC)
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
    return "SmallMessage[" + id + ", " + info + ", " + price + "]";
  }

}