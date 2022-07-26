import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { publicRoutes, privateRoutes } from "./routes";
import { DefaultLayout } from "./components/Layout";
import SlideBar from "./components/CommonComponent/SlideBar";

function App() {
    // console.log(<SlideBar className="class1 class2 class3"/>)
  return (
    <BrowserRouter>
        <div className="App">
            <Routes>
                {
                    publicRoutes.map(
                        (route, index) => {
                            const Layout = route.layout || DefaultLayout;
                            const Page = route.component;
                            return (
                                <Route
                                    key={index}
                                    path={route.path}
                                    element={
                                        <Layout>
                                            <Page/>
                                        </Layout>
                                    }>
                                </Route>
                            );
                        }
                    )
                }
            </Routes>

        </div>
    </BrowserRouter>
  );
}

export default App;
