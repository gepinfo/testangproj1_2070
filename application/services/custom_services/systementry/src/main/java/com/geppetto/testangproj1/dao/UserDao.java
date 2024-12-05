package com.geppetto.testangproj1.dao;


public interface UserDao {

    {GpUpdate=Optional<User>, GpFileUpload=User, GpGetAllValues=Page<User>, GpCreate=User, GpGetEntityById=Optional<User>, GpFileDownload=Optional<User>, GpDelete=void} {GpCreate=createUser, GpGetEntityById=getUserById, GpUpdate=updateUser, GpDelete=deleteUser, GpGetAllValues=getAllUser, GpFileUpload=fileUploadUser, GpFileDownload=fileDownloadUser}({GpCreate=User user, GpUpdate=String id, GpGetEntityById=String id, GpDelete=String id, GpGetAllValues=Pageable pageable, GpFileUpload=User fileEvent, GpFileDownload=String fileName});

}

