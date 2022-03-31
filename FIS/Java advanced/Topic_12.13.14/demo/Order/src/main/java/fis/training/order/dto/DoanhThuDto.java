package fis.training.order.dto;

public class DoanhThuDto {
    public String name;
    public Double totalMoney;
    public DoanhThuDto(String name, Double totalMoney) {
        super();
        this.name = name;
        this.totalMoney = totalMoney;
    }
    public DoanhThuDto() {
        super();
        // TODO Auto-generated constructor stub
    }
}
