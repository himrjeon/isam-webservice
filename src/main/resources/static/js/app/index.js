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

        // guestbook
        $('#btn-guest-submit').on('click', function () {
            _this.guestsave();
        });

        $('#btn-guest-update').on('click', function() {
            _this.guestupdate();
        });

        $('#btn-guest-delete').on('click', function() {
            _this.guestdelete();
        });

        $('#btnReplySave').on('click', function() {
            _this.postcommentsave();
        });

        $('#btn-carguest-submit').on('click', function () {
                    _this.carguestsave();
        });

                $('#btn-carguest-delete').on('click', function () {
                            _this.carguestdelete();
                });


                $('#popup-btn-save').on('click', function () {
                    _this.popupsave();
                });

                $('#popup-btn-update').on('click', function () {
                    _this.popupdate();
                });

                $('#btn-popup-delete').on('click', function () {
                    _this.popupdelete();
                });
        $('#car-btn-delete').on('click', function () {
            _this.importcardelete();
        });
        $('#usedcar-btn-delete').on('click', function () {
            _this.usedcardelete();
        });

        },
    save : function () {
            var content = editor.getHtml();
            document.getElementById("content").value = content;
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
            var content = editor.getHtml();
            document.getElementById("content").value = content;

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
            var content = editor.getHtml();
            document.getElementById("content").value = content;

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
                        window.location.href = '/admin/news';
                    }).fail(function (error) {
                        alert(JSON.stringify(error));
                    });
            },

     // 신규로 추가될 업데이트 함수 기능
     newsupdate : function() {
            var content = editor.getHtml();
            document.getElementById("content").value = content;

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
                window.location.href = '/admin/news';
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
            window.location.href = '/admin/news';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });

     },

         noticesave : function () {

            var content = editor.getHtml();
            document.getElementById("content").value = content;
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
                             window.location.href = '/admin/notice';
                         }).fail(function (error) {
                             alert(JSON.stringify(error));
                         });
                 },

          // 신규로 추가될 업데이트 함수 기능
          noticeupdate : function() {
            var content = editor.getHtml();
            document.getElementById("content").value = content;

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
                     window.location.href = '/admin/notice';
                 }).fail(function (error) {
                     alert(JSON.stringfy(error));
                 });
          },

          noticedelete : function () {
             var id = $('#id').val();

             $.ajax({
                 type: 'DELETE',
                 url: '/api/v1/notice/'+id,
                 dataType: 'json',
                 contentType: 'application/json; charset=utf-8'
             }).done(function() {
                 alert('글이 삭제되었습니다. ');
                 window.location.href = '/admin/notice';
             }).fail(function (error) {
                 alert(JSON.stringify(error));
             });

          },

         guestsave : function () {
                 var data = {
                     guestname: $('#guestname').val(),
                     phonenum: $('#phonenum').val(),
                     email: $('#email').val(),
                     content: $('#content').val()
                 };
                 $.ajax({
                             type: 'POST',
                             url: '/api/v2/guestbook',
                             dataType: 'json',
                             contentType:'application/json; charset=utf-8',
                             data: JSON.stringify(data)
                         }).done(function() {
                             alert('상담신청이 완료되었습니다. 등록해주신 연락처로 빠른 서비스 제공해드리겠습니다.');
                             window.location.href = '/contactus';
                         }).fail(function (error) {
                             alert(JSON.stringify(error));
                         });
                 },

          // 신규로 추가될 업데이트 함수 기능
          guestupdate : function() {
                 var data= {
                     title: $('#title').val(),
                     content: $('#content').val()
                 };

                 var id = $('#id').val();

                 // put 메소드는 putmapping을 사용했기 때문에. rest에서 crud는 생성 post, 읽기 get, 수정 put, 삭제 delete
                 // url은 어느 게시글을 수정할지에 대해 path에 id를 추가하여 구분.
                 $.ajax({
                     type: 'PUT',
                     url: '/api/v2/guestbook/update/'+id,
                     dataType: 'json',
                     contentType: 'application/json; charset=utf-8',
                     data: JSON.stringify(data)
                 }).done(function() {
                     alert('글이 수정되었습니다.');
                     window.location.href = '/contactus';
                 }).fail(function (error) {
                     alert(JSON.stringfy(error));
                 });
          },

          guestdelete : function () {
             var id = $('#id').val();

             $.ajax({
                 type: 'DELETE',
                 url: '/api/v2/guestbook/delete/'+id,
                 dataType: 'json',
                 contentType: 'application/json; charset=utf-8'
             }).done(function() {
                 alert('글이 삭제되었습니다.');
                 window.location.reload();
             }).fail(function (error) {
                 alert(JSON.stringify(error));
             });

          },

          postcommentsave : function () {
                 var data = {
                     memo: $('#memocontent').val(),
                     author: $('#memoauthor').val()
                 };
                 var id = $('#id').val();
                 $.ajax({
                             type: 'POST',
                             url: '/api/v1/postcomment/'+id,
                             dataType: 'json',
                             contentType:'application/json; charset=utf-8',
                             data: JSON.stringify(data)
                         }).done(function() {
                             alert('글이 등록되었습니다.');
                             window.location.reload();
                         }).fail(function (error) {
                             alert(JSON.stringify(error));
                         });

                    },

                 carguestsave : function () {
                         var data = {
                             carinfo: $('#carinfo').val(),
                             guestname: $('#guestname').val(),
                             phonenum: $('#phonenum').val(),
                             email: $('#email').val(),
                             content: $('#content').val()
                         };
                         $.ajax({
                                     type: 'POST',
                                     url: '/api/v2/carguestbook',
                                     dataType: 'json',
                                     contentType:'application/json; charset=utf-8',
                                     data: JSON.stringify(data)
                                 }).done(function() {
                                     alert('문의사항이 접수되었습니다. 등록해주신 연락처로 빠른 서비스 제공해드리겠습니다.');
                                     window.location.reload();
                                 }).fail(function (error) {
                                     alert(JSON.stringify(error));
                                 });
                         },

                  // 신규로 추가될 업데이트 함수 기능
                  carguestupdate : function() {
                         var data= {
                             title: $('#title').val(),
                             content: $('#content').val()
                         };

                         var id = $('#id').val();

                         // put 메소드는 putmapping을 사용했기 때문에. rest에서 crud는 생성 post, 읽기 get, 수정 put, 삭제 delete
                         // url은 어느 게시글을 수정할지에 대해 path에 id를 추가하여 구분.
                         $.ajax({
                             type: 'PUT',
                             url: '/api/v2/carguestbook/'+id,
                             dataType: 'json',
                             contentType: 'application/json; charset=utf-8',
                             data: JSON.stringify(data)
                         }).done(function() {
                             alert('글이 수정되었습니다.');
                             window.location.reload();
                         }).fail(function (error) {
                             alert(JSON.stringfy(error));
                         });
                  },

                  carguestdelete : function () {
                  var id = $('#id').val();

                  $.ajax({
                      type: 'DELETE',
                      url: '/api/v2/carguestbook/delete/'+id,
                      dataType: 'json',
                      contentType: 'application/json; charset=utf-8'
                  }).done(function() {
                      alert('글이 삭제되었습니다. ');
                      window.location.href = '/admin/carcontact';
                  }).fail(function (error) {
                      alert(JSON.stringify(error));
                  });

                  },
                           popupsave : function () {
                            var form = $('#insertForm')[0];
                                  var formData = new FormData(form);
                                  formData.append("file", $("#file")[0].files[0]);
                              $.ajax({
                                          type: 'POST',
                                          url: '/api/v2/popsave',
                                          processData: false,
                                          contentType: false,
                                          data: formData
                                      }).done(function() {
                                          alert('팝업이 등록되었습니다.');
                                          window.location.href = '/admin/popup';
                                      }).fail(function (error) {
                                          alert(JSON.stringify(error));
                                      });
                                      },

                       popupdate : function() {
                                  var form = $('#insertForm')[0];
                                  var formData = new FormData(form);
                                  formData.append("file", $("#file")[0].files[0]);
                                  var id = $('#id').val();
                              $.ajax({
                                  type: 'POST',
                                  url: '/api/v2/popup/'+id,
                                  processData: false,
                                  contentType: false,
                                  data: formData
                              }).done(function() {
                                  alert('팝업이 등록되었습니다.');
                                  window.location.href = '/admin/popup';
                              }).fail(function (error) {
                                  alert(JSON.stringfy(error));
                              });
                       },
                       popupdelete : function() {
                                  var id = $('#id').val();
                         $.ajax({
                         type: 'DELETE',
                         url: '/api/v2/popup/delete/'+id,
                         dataType: 'json',
                         contentType: 'application/json; charset=utf-8'
                     }).done(function() {
                         alert('팝업이 삭제되었습니다. ');
                         window.location.reload();
                     }).fail(function (error) {
                         alert(JSON.stringify(error));
                     });
                       },

                       importcardelete : function() {
                                  var id = $('#id').val();
                         $.ajax({
                         type: 'DELETE',
                         url: '/api/v2/importcar/delete/'+id,
                         dataType: 'json',
                         contentType: 'application/json; charset=utf-8'
                     }).done(function() {
                         alert('차량이 삭제되었습니다. ');
                         window.location.reload();
                     }).fail(function (error) {
                         alert(JSON.stringify(error));
                     });
                       },

                       usedcardelete : function() {
                                  var id = $('#id').val();
                         $.ajax({
                         type: 'DELETE',
                         url: '/api/v2/usedcar/delete/'+id,
                         dataType: 'json',
                         contentType: 'application/json; charset=utf-8'
                     }).done(function() {
                         alert('차량이 삭제되었습니다. ');
                         window.location.reload();
                     }).fail(function (error) {
                         alert(JSON.stringify(error));
                     });
                       }

    };
    main.init();