package com.manivchuk.tasklist.backendtasklist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Stat {

    @Id
    private Long id;

    private Long completedTotal;

    private Long uncompletedTotal;
}
