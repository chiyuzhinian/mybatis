# MyBatis + Spring Boot + Vue Starter (minimal)

1. 后端
   - 修改 application.yml 中的数据库连接（或直接使用 docker-compose）
   - 使用 Docker 启动 MySQL:
     docker-compose up -d
   - 或在本地 MySQL 中执行 schema.sql 创建数据库和表
   - 进入项目根目录运行:
     mvn spring-boot:run
   - 后端监听: http://localhost:8080

2. 前端（假设在 frontend 目录并使用 npm）
   - cd frontend
   - npm install
   - npm run serve
   - 前端默认在 http://localhost:3000 或 Vite 的默认端口，确保 proxy 指向后端或在 api 中使用完整后端地址。

3. 测试 API
   - GET /api/users
   - POST /api/users { "username":"test","password":"123","email":"a@b.com" }
   - GET /api/users/{id}
   - PUT /api/users/{id}
   - DELETE /api/users/{id}
