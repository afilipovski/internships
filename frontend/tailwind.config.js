/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors:{
        red: '#f84f5a',
        offblack: '#171717',
        finkiO: '#2A93D1',
        finkiI: '#313183',
        gray: '#bfbfbf',
        green: '#73E860',
      }
    },
  },
  plugins: [],
}

