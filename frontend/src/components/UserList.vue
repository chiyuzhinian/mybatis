<template>
  <div>
    <h2>Users</h2>
    <div>
      <input v-model="q" placeholder="search username"/>
      <button @click="fetch">Search</button>
      <button @click="openNew">New</button>
    </div>

    <table>
      <thead>
        <tr><th>ID</th><th>Username</th><th>Email</th><th>Actions</th></tr>
      </thead>
      <tbody>
        <tr v-for="u in users" :key="u.id">
          <td>{{u.id}}</td>
          <td>{{u.username}}</td>
          <td>{{u.email}}</td>
          <td>
            <button @click="edit(u)">Edit</button>
            <button @click="remove(u.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div v-if="showForm">
      <h3>{{editId ? 'Edit' : 'Create'}} User</h3>
      <input v-model="form.username" placeholder="username" />
      <input v-model="form.email" placeholder="email" />
      <input v-model="form.password" placeholder="password" />
      <button @click="submit">Save</button>
      <button @click="closeForm">Cancel</button>
    </div>
  </div>
</template>

<script>
import { listUsers, createUser, updateUser, deleteUser } from '../api/user';

export default {
  name: 'UserList',
  data() {
    return {
      q: '',
      users: [],
      page: 1,
      size: 10,
      showForm: false,
      editId: null,
      form: { username: '', email: '', password: '' }
    }
  },
  methods: {
    async fetch() {
      const res = await listUsers({ username: this.q, page: this.page, size: this.size });
      this.users = res.data.data;
    },
    openNew() {
      this.editId = null;
      this.form = { username: '', email: '', password: '' };
      this.showForm = true;
    },
    edit(user) {
      this.editId = user.id;
      this.form = { username: user.username, email: user.email, password: ''};
      this.showForm = true;
    },
    closeForm() {
      this.showForm = false;
    },
    async submit() {
      if (this.editId) {
        await updateUser(this.editId, this.form);
      } else {
        await createUser(this.form);
      }
      this.showForm = false;
      this.fetch();
    },
    async remove(id) {
      if (!confirm('Delete?')) return;
      await deleteUser(id);
      this.fetch();
    }
  },
  mounted() {
    this.fetch();
  }
}
</script>
