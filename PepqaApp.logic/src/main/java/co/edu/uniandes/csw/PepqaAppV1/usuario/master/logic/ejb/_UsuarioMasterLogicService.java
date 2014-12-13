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

package co.edu.uniandes.csw.PepqaAppV1.usuario.master.logic.ejb;

import co.edu.uniandes.csw.PepqaAppV1.evento.logic.dto.EventoDTO;
import co.edu.uniandes.csw.PepqaAppV1.evento.persistence.api.IEventoPersistence;
import co.edu.uniandes.csw.PepqaAppV1.usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.PepqaAppV1.usuario.master.logic.api._IUsuarioMasterLogicService;
import co.edu.uniandes.csw.PepqaAppV1.usuario.master.logic.dto.UsuarioMasterDTO;
import co.edu.uniandes.csw.PepqaAppV1.usuario.master.persistence.api.IUsuarioMasterPersistence;
import co.edu.uniandes.csw.PepqaAppV1.usuario.master.persistence.entity.UsuarioeventosUsEntity;
import co.edu.uniandes.csw.PepqaAppV1.usuario.persistence.api.IUsuarioPersistence;
import javax.inject.Inject;

public abstract class _UsuarioMasterLogicService implements _IUsuarioMasterLogicService {

    @Inject
    protected IUsuarioPersistence usuarioPersistance;
    @Inject
    protected IUsuarioMasterPersistence usuarioMasterPersistance;
    @Inject
    protected IEventoPersistence eventoPersistance;

    public UsuarioMasterDTO createMasterUsuario(UsuarioMasterDTO usuario) {
        UsuarioDTO persistedUsuarioDTO = usuarioPersistance.createUsuario(usuario.getUsuarioEntity());
        if (usuario.getCreateeventosUs() != null) {
            for (EventoDTO eventoDTO : usuario.getCreateeventosUs()) {
                EventoDTO createdEventoDTO = eventoPersistance.createEvento(eventoDTO);
                UsuarioeventosUsEntity usuarioEventoEntity = new UsuarioeventosUsEntity(persistedUsuarioDTO.getId(), createdEventoDTO.getId());
                usuarioMasterPersistance.createUsuarioeventosUsEntity(usuarioEventoEntity);
            }
        }
        // update evento
        if (usuario.getUpdateeventosUs() != null) {
            for (EventoDTO eventoDTO : usuario.getUpdateeventosUs()) {
                eventoPersistance.updateEvento(eventoDTO);
                UsuarioeventosUsEntity usuarioEventoEntity = new UsuarioeventosUsEntity(persistedUsuarioDTO.getId(), eventoDTO.getId());
                usuarioMasterPersistance.createUsuarioeventosUsEntity(usuarioEventoEntity);
            }
        }
        return usuario;
    }

    public UsuarioMasterDTO getMasterUsuario(Long id) {
        return usuarioMasterPersistance.getUsuario(id);
    }

    public void deleteMasterUsuario(Long id) {
        usuarioPersistance.deleteUsuario(id);
    }

    public void updateMasterUsuario(UsuarioMasterDTO usuario) {
        usuarioPersistance.updateUsuario(usuario.getUsuarioEntity());

        //---- FOR RELATIONSHIP
        // delete evento
        if (usuario.getDeleteeventosUs() != null) {
            for (EventoDTO eventoDTO : usuario.getDeleteeventosUs()) {
                usuarioMasterPersistance.deleteUsuarioeventosUsEntity(usuario.getUsuarioEntity().getId(), eventoDTO.getId());
            }
        }
        // persist new evento
        if (usuario.getCreateeventosUs() != null) {
            for (EventoDTO eventoDTO : usuario.getCreateeventosUs()) {
                UsuarioeventosUsEntity usuarioEventoEntity = new UsuarioeventosUsEntity(usuario.getUsuarioEntity().getId(), eventoDTO.getId());
                usuarioMasterPersistance.createUsuarioeventosUsEntity(usuarioEventoEntity);
            }
        }
        // update evento
        if (usuario.getUpdateeventosUs() != null) {
            for (EventoDTO eventoDTO : usuario.getUpdateeventosUs()) {
                usuarioMasterPersistance.deleteUsuarioeventosUsEntity(usuario.getUsuarioEntity().getId(), eventoDTO.getId());
                eventoPersistance.updateEvento(eventoDTO);
                UsuarioeventosUsEntity usuarioEventoEntity = new UsuarioeventosUsEntity(usuario.getId(), eventoDTO.getId());
                usuarioMasterPersistance.createUsuarioeventosUsEntity(usuarioEventoEntity);
                
            }
        }
    }
}
