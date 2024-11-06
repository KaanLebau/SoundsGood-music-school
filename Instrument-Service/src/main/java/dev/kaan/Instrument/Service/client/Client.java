package dev.kaan.Instrument.Service.client;

import dev.kaan.Instrument.Service.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseEntity {

    @Column(name = "clientNo", nullable = false,updatable = false,unique = true)
    Long clientNo;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "role", nullable = false)
    Role role;

    public static class Builder {
        private Long id;
        private LocalDate createdDate;
        private LocalDate updatedDate;
        private Long clientNo;
        private String name;
        private Role role;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder createdDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder updatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public Builder clientNo(Long clientNo) {
            this.clientNo = clientNo;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.setId(id);
            client.setCreatedDate(createdDate);
            client.setUpdatedDate(updatedDate);
            client.setClientNo(clientNo);
            client.setName(name);
            client.setRole(role);
            return client;
        }
    }

    // Static method to access the builder
    public static Builder builder() {
        return new Builder();
    }

}
