var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        // btn-update란 id 가진 html click 이베트 발생시 update 함수 발생
        $('#btn-update').on('click', function() {
            _this.update();
        });

        $('#btn-delete').on('click', function() {
            _this.delete();
        });

        $('#btn-news-save').on('click', function () {
            _this.news_save();
        });

        // btn-update란 id 가진 html click 이베트 발생시 update 함수 발생
        $('#btn-news-update').on('click', function() {
            _this.newsupdate();
        });

        $('#btn-news-delete').on('click', function() {
            _this.newsdelete();
        });

        $('#btn-notice-save').on('click', function () {
            _this.noticesave();
        });

        // btn-update란 id 가진 html click 이베트 발생시 update 함수 발생
        $('#btn-notice-update').on('click', function() {
            _this.noticeupdate();
        });

        $('#btn-notice-delete').on('click', function() {
            _this.noticedelete();
        });



        },
    save : function () {
            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val()
            };
            $.ajax({
                        type: 'POST',
                        url: '/api/v1/posts',
                        dataType: 'json',
                        contentType:'application/json; charset=utf-8',
                        data: JSON.stringify(data)
                    }).done(function() {
                        alert('글이 등록되었습니다.');
                        window.location.href = '/freeboard';
                    }).fail(function (error) {
                        alert(JSON.stringify(error));
                    });
            },

     // 신규로 추가될 업데이트 함수 기능
     update : function() {
            var data= {
                title: $('#title').val(),
                content: $('#content').val()
            };

            var id = $('#id').val();

            // put 메소드는 putmapping을 사용했기 때문에. rest에서 crud는 생성 post, 읽기 get, 수정 put, 삭제 delete
            // url은 어느 게시글을 수정할지에 대해 path에 id를 추가하여 구분.
            $.ajax({
                type: 'PUT',
                url: '/api/v1/posts/'+id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 수정되었습니다.');
                window.location.href = '/freeboard';
            }).fail(function (error) {
                alert(JSON.stringfy(error));
            });
     },

     delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다. ');
            window.location.href = '/freeboard';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

     },

    news_save : function () {
            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                content: $('#content').val()
            };
            $.ajax({
                        type: 'POST',
                        url: '/api/v1/news',
                        dataType: 'json',
                        contentType:'application/json; charset=utf-8',
                        data: JSON.stringify(data)
                    }).done(function() {
                        alert('글이 등록되었습니다.');
                        window.location.href = '/news';
                    }).fail(function (error) {
                        alert(JSON.stringify(error));
                    });
            },

     // 신규로 추가될 업데이트 함수 기능
     newsupdate : function() {
            var data= {
                title: $('#title').val(),
                content: $('#content').val()
            };

            var id = $('#id').val();

            // put 메소드는 putmapping을 사용했기 때문에. rest에서 crud는 생성 post, 읽기 get, 수정 put, 삭제 delete
            // url은 어느 게시글을 수정할지에 대해 path에 id를 추가하여 구분.
            $.ajax({
                type: 'PUT',
                url: '/api/v1/news/'+id,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 수정되었습니다.');
                window.location.href = '/news';
            }).fail(function (error) {
                alert(JSON.stringfy(error));
            });
     },

     newsdelete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/news/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다. ');
            window.location.href = '/news';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

     },

         noticesave : function () {
                 var data = {
                     title: $('#title').val(),
                     author: $('#author').val(),
                     content: $('#content').val()
                 };
                 $.ajax({
                             type: 'POST',
                             url: '/api/v1/notice',
                             dataType: 'json',
                             contentType:'application/json; charset=utf-8',
                             data: JSON.stringify(data)
                         }).done(function() {
                             alert('글이 등록되었습니다.');
                             window.location.href = '/notice';
                         }).fail(function (error) {
                             alert(JSON.stringify(error));
                         });
                 },

          // 신규로 추가될 업데이트 함수 기능
          noticeupdate : function() {
                 var data= {
                     title: $('#title').val(),
                     content: $('#content').val()
                 };

                 var id = $('#id').val();

                 // put 메소드는 putmapping을 사용했기 때문에. rest에서 crud는 생성 post, 읽기 get, 수정 put, 삭제 delete
                 // url은 어느 게시글을 수정할지에 대해 path에 id를 추가하여 구분.
                 $.ajax({
                     type: 'PUT',
                     url: '/api/v1/notice/'+id,
                     dataType: 'json',
                     contentType: 'application/json; charset=utf-8',
                     data: JSON.stringify(data)
                 }).done(function() {
                     alert('글이 수정되었습니다.');
                     window.location.href = '/notice';
                 }).fail(function (error) {
                     alert(JSON.stringfy(error));
                 });
          },

          noticesdelete : function () {
             var id = $('#id').val();

             $.ajax({
                 type: 'DELETE',
                 url: '/api/v1/notice/'+id,
                 dataType: 'json',
                 contentType: 'application/json; charset=utf-8'
             }).done(function() {
                 alert('글이 삭제되었습니다. ');
                 window.location.href = '/notice';
             }).fail(function (error) {
                 alert(JSON.stringify(error));
             });

          }

    };
    main.init();