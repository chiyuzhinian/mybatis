<template>
  <div class="page">
    <h1>User Management</h1>
    <UserList />
  </div>
</template>

<script>
import UserList from '../components/UserList.vue'
export default {
  name: 'UsersView',
  components: { UserList }
}
</script>
