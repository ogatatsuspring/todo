insert into todos( todo, detail, created_at, updated_at )
values( '買い物', 'スーパーで食材を購入する', current_timestamp, current_timestamp );

insert into todos( todo, detail, created_at, updated_at )
values( '図書館に行く', '本を借りる', current_timestamp, current_timestamp );

insert into todos( todo, detail, created_at, updated_at )
values( 'ジムに行く', '運動する', current_timestamp, current_timestamp );



/*
insert into authentications( username, password )
values( 'admin', 'adminpass' );
*/


insert into authentications( username, password, authority, displayname )
values( 'admin', '$2a$10$cJAbGIYRBBFoawUSRd8x3e5tI0ouW4S02TgQBx/pDv0y3CrXrcebC', 'ADMIN', '管理太郎' );

insert into authentications( username, password, authority, displayname )
values( 'user', '$2a$10$YwKVsSNu3Vsf/pkk0hRWZe7mkfHQvVe3dMEpMgdXBagbakE80qVZy', 'USER', '一般花子' );

