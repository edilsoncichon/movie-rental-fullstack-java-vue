<template>
  <side-bar class="sidebar-customer">
    <div class="container">
      <form>
        <div class="form-group">
          <label for="categoria">Categoria</label>
          <select class="form-control" id="categoria">
            <option selected>Selecione...</option>
            <option value="1">Ação</option>
            <option value="2">Aventura</option>
            <option value="3">Suspense</option>
          </select>
        </div>
        <div class="form-group">
          <label for="titulo">Titulo</label>
          <input type="text" class="form-control" id="titulo" placeholder="Filme">
        </div>
        <div class="form-group">
          <label for="ator">Ator</label>
          <select class="form-control" id="ator">
            <option selected>Selecione...</option>
            <option value="1">Angelina Joli</option>
            <option value="2">Jontravolta</option>
            <option value="3">Robin Udi</option>
          </select>
        </div>
        <button type="submit" class="btn btn-primary">Pesquisar</button>
      </form>
    </div>
  </side-bar>
</template>

<script>
import SideBar from '@/components/SideBar'
export default {
  name: 'SideBarCustomer',
  components: {
    SideBar
  }
}
</script>
