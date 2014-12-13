 

   ALTER TABLE APP.PepqaAppusuariosEntity ADD FOREIGN KEY (pepqaAppId) REFERENCES  APP.PepqaAppEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
   ALTER TABLE APP.PepqaAppusuariosEntity ADD FOREIGN KEY (usuariosId) REFERENCES  APP.UsuarioEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
   ALTER TABLE APP.PepqaAppeventosEntity ADD FOREIGN KEY (pepqaAppId) REFERENCES  APP.PepqaAppEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
   ALTER TABLE APP.PepqaAppeventosEntity ADD FOREIGN KEY (eventosId) REFERENCES  APP.EventoEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
		
   ALTER TABLE APP.UsuarioeventosUsEntity ADD FOREIGN KEY (usuarioId) REFERENCES  APP.UsuarioEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
   ALTER TABLE APP.UsuarioeventosUsEntity ADD FOREIGN KEY (eventosUsId) REFERENCES  APP.EventoEntity(id) ON DELETE CASCADE ON UPDATE RESTRICT;
		