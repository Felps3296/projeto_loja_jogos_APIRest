# API de Venda de Jogos 🎮

Esta é uma API REST para gerenciamento de vendas de jogos. A API permite que clientes comprem jogos disponíveis no catálogo, gerencie seu estoque e mantenha o controle das vendas realizadas. O projeto utiliza autenticação JWT e o banco de dados MySQL.

<h2>🎮 Funcionalidades</h2>

<ul>
    <li><strong>Regras de Negócio</strong>:
        <ul>
            <li>Um jogo só pode ser vendido se a quantidade disponível no estoque for suficiente para atender ao pedido do cliente.</li>
            <li>Após a conclusão da compra, a quantidade dos jogos no estoque é reduzida de acordo com a compra realizada.</li>
            <li>Após a realização de uma venda, um registro é criado no banco de dados para fins de auditoria.</li>
            <li>As vendas devem estar associadas a um cliente e aos jogos comprados, com suas respectivas quantidades e preços.</li>
        </ul>
    </li>
</ul>

<h2>🛠️ Tecnologias Utilizadas</h2>
<div>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>
<ul>
    <li><strong>Java 17</strong></li>
    <li><strong>Spring Boot 3.0</strong></li>
    <li><strong>MySQL</strong> (ou H2 para testes)</li>
    <li><strong>Bean Validation</strong> (para validações nos DTOs)</li>
    <li><strong>Postman</strong> (para testar a API)</li>
    <li><strong>JWT (JSON Web Token)</strong>Para autenticação e autorização</li>
</ul>

## 🚀 Funcionalidades
## ⚙️ Funcionalidades

- [ ] CRUD de Games;
- [ ] CRUD de clientes;
- [ ] CRUD de vendas

## 📌 Pré-requisitos
- **Java 17**
- **Maven**
- **MySQL** (Servidor local ou remoto)

<h2>✍️ Autor</h2>

[<img loading="lazy" src="https://avatars.githubusercontent.com/u/64935845?v=4" width=115><br><sub>Felipe Viana Reis</sub>](https://github.com/Felps3296)

