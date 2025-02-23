// src/components/ProductComponent.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const ProductComponent = () => {
  const [products, setProducts] = useState([]);
  const [newProduct, setNewProduct] = useState({ prodName: '', price: 0 });

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      const response = await axios.get('/products');
      setProducts(response.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewProduct({
      ...newProduct,
      [name]: value
    });
  };

  const addProduct = async () => {
    try {
      const newProdId = Math.max(...products.map(p => p.prodId), 0) + 1;
      const productToAdd = { ...newProduct, prodId: newProdId };

      await axios.post('/products', productToAdd);
      fetchProducts();
      setNewProduct({ prodName: '', price: 0 });
    } catch (error) {
      console.error('Error adding product:', error);
    }
  };

  const deleteProduct = async (prodId) => {
    try {
      await axios.delete(`/products/id==${prodId}`);
      fetchProducts();
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  const getRandomIcon = () => {
    const icons = ['fa-laptop', 'fa-mobile-alt', 'fa-desktop', 'fa-tablet-alt'];
    return icons[Math.floor(Math.random() * icons.length)];
  };

  return (
    <div>
      <h2>Products</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '10px' }}>
        {products.map((product) => {
          const icon = getRandomIcon();
          return (
            <div key={product.prodId} style={{ width: '150px', textAlign: 'center' }}>
              <i className={`fas ${icon}`} style={{ fontSize: '50px', color: '#007bff' }}></i>
              <p>{product.prodName}</p>
              <p>${product.price}</p>
              <button onClick={() => deleteProduct(product.prodId)}>Delete</button>
            </div>
          );
        })}
      </div>

      <h2>Add New Product</h2>
      <input
        type="text"
        name="prodName"
        value={newProduct.prodName}
        onChange={handleInputChange}
        placeholder="Product Name"
      />
      <input
        type="number"
        name="price"
        value={newProduct.price}
        onChange={handleInputChange}
        placeholder="Price"
      />
      <button onClick={addProduct}>Add Product</button>
    </div>
  );
};

export default ProductComponent;