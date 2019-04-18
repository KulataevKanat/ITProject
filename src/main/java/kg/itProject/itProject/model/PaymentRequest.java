package kg.itProject.itProject.model;

import java.math.BigDecimal;

public class PaymentRequest {
    private String login;
    private BigDecimal sum;


    public PaymentRequest() {
    }

    public PaymentRequest(String login, BigDecimal sum) {
        this.login = login;
        this.sum = sum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
