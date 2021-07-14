import { LitElement, html } from 'lit-element';

export class HomePokemon extends LitElement {

  /**
    * Object describing property-related metadata used by Polymer features
    */
  static get properties() {
      return {
          clic: {type: Number}
      };
  }

   constructor(){
       super();
       this.clic = 0;
   }

    render() {
        return html`
        <p>Hola ${ this.clic }</p>
        
            `;

        
    }
}
customElements.define('home-pokemon', HomePokemon);