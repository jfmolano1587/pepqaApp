/* ========================================================================
 * Copyright 2014 PepqaAppV1
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 PepqaAppV1

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201411201032

*/

package co.edu.uniandes.csw.PepqaAppV1.usuario.master.persistence.entity;

import co.edu.uniandes.csw.PepqaAppV1.evento.persistence.entity.EventoEntity;
import co.edu.uniandes.csw.PepqaAppV1.usuario.persistence.entity.UsuarioEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(UsuarioeventosUsEntityId.class)
@NamedQueries({
    @NamedQuery(name = "UsuarioeventosUsEntity.getByMasterId", query = "SELECT  u FROM UsuarioeventosUsEntity u WHERE u.usuarioId=:usuarioId"),
    @NamedQuery(name = "UsuarioeventosUsEntity.deleteUsuarioeventosUsEntity", query = "DELETE FROM UsuarioeventosUsEntity u WHERE u.usuarioId=:usuarioId and  u.eventosUsId=:eventosUsId")
})
public class UsuarioeventosUsEntity implements Serializable {

    @Id
    @Column(name = "usuarioId")
    private Long usuarioId;
    @Id
    @Column(name = "eventosUsId")
    private Long eventosUsId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "usuarioId", referencedColumnName = "id")
    @JoinFetch
    private EventoEntity usuarioIdEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "eventosUsId", referencedColumnName = "id")
    @JoinFetch
    private EventoEntity eventosUsIdEntity; 

    public UsuarioeventosUsEntity() {
    }

    public UsuarioeventosUsEntity(Long usuarioId, Long eventosUsId) {
        this.usuarioId =usuarioId;
        this.eventosUsId = eventosUsId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getEventosUsId() {
        return eventosUsId;
    }

    public void setEventosUsId(Long eventosUsId) {
        this.eventosUsId = eventosUsId;
    }

    public EventoEntity getUsuarioIdEntity() {
        return usuarioIdEntity;
    }

    public void setUsuarioIdEntity(EventoEntity usuarioIdEntity) {
        this.usuarioIdEntity = usuarioIdEntity;
    }

    public EventoEntity getEventosUsIdEntity() {
        return eventosUsIdEntity;
    }

    public void setEventosUsIdEntity(EventoEntity eventosUsIdEntity) {
        this.eventosUsIdEntity = eventosUsIdEntity;
    }

}
