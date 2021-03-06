package co.stqa.pft.addressbook.model;

public class GroupData {

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("GroupData{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }

  public void setId(int id) {
    this.id = id;
  }

  private int id;
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(int id,String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
    this.id=Integer.MAX_VALUE;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public int getId() {
    return id;
  }

  public String getFooter() {
    return footer;
  }


}
